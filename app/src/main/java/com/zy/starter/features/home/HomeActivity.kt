package com.zy.starter.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dylanc.viewbinding.binding
import com.zy.starter.api.WanAndroidApi
import com.zy.starter.databinding.ActivityHomeBinding
import com.zy.starter.network.ApiClient
import com.zy.starter.network.ApiResult
import com.zy.starter.network.safeApiCall
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by binding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun fetchData() {
        lifecycleScope.launch {
            val result = safeApiCall {
                ApiClient.create(WanAndroidApi::class.java).getBanners()
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

    private fun initListeners() {
        binding.run {
            imageView.setOnClickListener {
                fetchData()
            }
        }
    }

}