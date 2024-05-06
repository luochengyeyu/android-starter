package com.zy.starter.features.home.ui

import android.os.Bundle
import com.dylanc.longan.startActivity
import com.zy.starter.R
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        setToolbar("HomeActivity")
        binding.run {
            imageView.setOnClickListener {

            }
        }
    }

}