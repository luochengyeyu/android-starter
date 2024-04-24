package com.zy.starter.network

import com.zy.starter.network.base.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException
import java.net.UnknownHostException

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> BaseResponse<T>): ApiResult<T> {
    return withContext(Dispatchers.IO) {  // 在IO线程上下文中执行网络请求
        try {
            val response = apiCall()  // 执行挂起函数
            if (response.isSuccessful()) {
                // code = 0 的情况，将响应体封装在Result.Success
                val data = response.data
                if (data != null) {
                    ApiResult.Success(data)
                } else {
                    // 如果响应体为空，将错误信息封装在Result.Error
                    ApiResult.Error(
                        ApiException(
                            ApiErrors.DATA_NULL_ERROR.code,
                            ApiErrors.DATA_NULL_ERROR.msg
                        )
                    )
                }
            } else {
                // 如果code != 0，将错误信息封装在Result.Error
                ApiResult.Error(
                    ApiException(
                        ApiErrors.INTERNAL_ERROR.code,
                        ApiErrors.INTERNAL_ERROR.msg
                    )
                )
            }
        } catch (e: Exception) {
            // 捕获执行中的异常，并将异常封装在Result.Error
            val exception = when (e) {
                is UnknownHostException, is SocketTimeoutException -> {
                    ApiException(
                        ApiErrors.NETWORK_ERROR.code,
                        ApiErrors.NETWORK_ERROR.msg
                    )
                }

                else -> ApiException(ApiErrors.UNKNOWN_ERROR.code, ApiErrors.UNKNOWN_ERROR.msg)
            }
            ApiResult.Error(exception)
        }
    }
}