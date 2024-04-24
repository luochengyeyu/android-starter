package com.zy.starter.features.home

import androidx.lifecycle.lifecycleScope
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityHomeBinding
import com.zy.starter.features.wanandroid.WanAndroidApi
import com.zy.starter.network.ApiCall
import com.zy.starter.network.ApiResult
import com.zy.starter.network.safeApiCall
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun initViews() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            imageView.setOnClickListener {
                fetchData()
            }
        }
    }

    override fun fetchData() {
        lifecycleScope.launch {
            val result = safeApiCall {
                ApiCall.create(WanAndroidApi::class.java).getBanners()
            }
            when (result) {
                is ApiResult.Success -> {
                    binding.textView.text = result.data.toString()
                }

                is ApiResult.Error -> {
                    binding.textView.text = result.exception.message
                }
            }

        }
    }
}