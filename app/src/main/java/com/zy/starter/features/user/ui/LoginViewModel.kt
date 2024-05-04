package com.zy.starter.features.user.ui

import androidx.lifecycle.viewModelScope
import com.zy.starter.base.BaseViewModel
import com.zy.starter.base.UiEffect
import com.zy.starter.base.UiEvent
import com.zy.starter.base.UiState
import com.zy.starter.features.user.data.LoginRepository
import com.zy.starter.extensions.commonCatch
import com.zy.starter.features.user.data.toUserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val isLoading: Boolean = false,
) : UiState

sealed class LoginEvent : UiEvent {
    data class UpdateAccount(val account: String) : LoginEvent()
    data class UpdatePassword(val password: String) : LoginEvent()
    data class Login(val username: String, val password: String) : LoginEvent()
}

sealed class LoginEffect : UiEffect {
    data class ShowToast(val message: String) : LoginEffect()
    data class ShowSnackBar(val message: String) : LoginEffect()
    data object NavigateToHome : LoginEffect()
}

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    BaseViewModel<LoginUiState, LoginEvent, LoginEffect>() {
    override fun createInitialState(): LoginUiState = LoginUiState()
    override fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> {
                login(event.username, event.password)
            }

            is LoginEvent.UpdateAccount -> {
            }

            is LoginEvent.UpdatePassword -> {

            }
        }
    }

    private fun login(username: String, password: String) {
        viewModelScope.launch {
            repository.login(username, password)
                .onStart {
                    setState {
                        copy(isLoading = true)
                    }
                }
                .onCompletion {
                    setState {
                        copy(isLoading = false)
                    }
                }
                // 处理异常
                .commonCatch {}
                .collect { result ->
                    result.onSuccess {
                        val userInfo = it.toUserInfo()
                        setEffect {
                            LoginEffect.ShowToast("${userInfo.nickname}登录成功")
                        }
                        setEffect {
                            LoginEffect.NavigateToHome
                        }
                    }.onFailure {
                        it.message?.let {
                            setEffect {
                                LoginEffect.ShowToast(it)
                            }
                        }
                    }
                }
        }
    }
}

