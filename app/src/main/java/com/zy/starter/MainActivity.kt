package com.zy.starter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.longan.startActivity
import com.dylanc.viewbinding.binding
import com.zy.starter.databinding.ActivityMainBinding
import com.zy.starter.features.home.HomeActivity
import com.zy.starter.features.user.ui.LoginActivity
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by binding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.run {
            btnHome.setOnClickListener {
                startActivity<HomeActivity>()
            }
            btnLogin.setOnClickListener {
                startActivity<LoginActivity>()
            }
        }
    }

}

