package com.zy.starter

import android.content.Intent
import android.os.Bundle
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityMainBinding
import com.zy.starter.features.home.HomeActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun initViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            btnHome.setOnClickListener {
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))

            }
        }
    }

    override fun fetchData() {

    }


}