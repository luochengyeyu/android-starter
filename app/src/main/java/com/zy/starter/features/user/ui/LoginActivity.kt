package com.zy.starter.features.user.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dylanc.longan.hideKeyboard
import com.dylanc.longan.logDebug
import com.dylanc.longan.startActivity
import com.dylanc.longan.toast
import com.zy.starter.base.BaseActivity
import com.zy.starter.base.LoadingView
import com.zy.starter.databinding.ActivityLoginBinding
import com.zy.starter.features.home.ui.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar("登录")
        initListeners()
    }

    private fun initListeners() {
        binding.run {
            btnLogin.setOnClickListener {
                viewModel.sendEvent(
                    LoginEvent.Login(
                        binding.etUsername.text.toString(),
                        binding.etPassword.text.toString()
                    )
                )
                it.hideKeyboard()
            }
        }
        // 观察界面状态并做出响应
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    handleLoadingView(it.loadingView)
                }
            }
        }
        // 观察一次性事件并做出响应
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is LoginEffect.ShowToast -> {
                            toast(it.message)
                        }

                        is LoginEffect.NavigateToHome -> {
                            finish()
                            startActivity<HomeActivity>()
                        }
                    }
                }
            }
        }
    }

    private fun handleLoadingView(loadingView: LoadingView) {
        when (loadingView) {
            LoadingView.Loading -> {
                showLoadingView()
            }

            LoadingView.Empty -> {
                showEmptyView()
            }

            LoadingView.Error -> {
                showErrorView()
            }

            LoadingView.Content -> {
                showContentView()
            }
        }
    }

}