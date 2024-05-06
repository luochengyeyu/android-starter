package com.zy.starter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dylanc.loadingstateview.NavBtnType
import com.dylanc.longan.startActivity
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityMainBinding
import com.zy.starter.features.home.ui.HomeActivity
import com.zy.starter.features.home.ui.ImageActivity
import com.zy.starter.features.user.ui.LoginActivity
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
        setToolbar("MainActivity",NavBtnType.NONE)
    }

    private fun initListeners() {
        binding.run {
            btnHome.setOnClickListener {
                startActivity<HomeActivity>()
            }
            btnLogin.setOnClickListener {
                startActivity<LoginActivity>()
            }
            btnImage.setOnClickListener {
                startActivity<ImageActivity>()
            }
        }
    }

}

