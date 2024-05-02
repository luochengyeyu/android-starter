package com.zy.starter.features.login.ui

import androidx.lifecycle.viewModelScope
import com.zy.starter.base.BaseViewModel
import com.zy.starter.base.UiEffect
import com.zy.starter.base.UiEvent
import com.zy.starter.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

class LoginViewModel : BaseViewModel<LoginUiState, LoginEvent, LoginEffect>() {
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
            withContext(Dispatchers.IO) {
                setState {
                    copy(isLoading = true)
                }
                delay(3000)
                setState {
                    copy(isLoading = false)
                }
                setEffect {
                    LoginEffect.ShowToast("登录成功")
                }
                setEffect {
                    LoginEffect.NavigateToHome
                }
            }
        }
    }
}

