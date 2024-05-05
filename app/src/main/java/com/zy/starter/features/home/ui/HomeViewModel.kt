package com.zy.starter.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zy.starter.features.home.data.Banner
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    fun getBanner() {
        viewModelScope.launch {
//            val result = safeApiCall { ApiCall.create(WanAndroidApi::class.java).getBanner() }
//            when (result) {
//                is ApiResult.Success -> handleSuccess(result.data)
//                is ApiResult.Error -> handleError(result.exception)
//            }
        }
    }

    private fun handleSuccess(banners: List<Banner>) {
        // 更新 UI 或进行其他业务处理
        println("Banners: $banners")
    }

    private fun handleError(ex: Exception) {
        // 显示错误信息或处理网络错误
        println("Ex: ${ex.message}")
    }
}