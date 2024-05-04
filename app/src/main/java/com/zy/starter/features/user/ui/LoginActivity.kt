package com.zy.starter.features.user.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dylanc.longan.hideKeyboard
import com.dylanc.longan.logDebug
import com.dylanc.longan.startActivity
import com.dylanc.longan.toast
import com.dylanc.viewbinding.binding
import com.zy.starter.databinding.ActivityLoginBinding
import com.zy.starter.features.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by binding()
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    binding.pbLoading.visibility = if (it.isLoading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                    binding.btnLogin.isEnabled = !it.isLoading
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
                        is LoginEffect.ShowSnackBar -> {
                            logDebug(it.message)
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

}