package com.zy.starter.base

import com.zy.starter.api.WanAndroidService
import com.zy.starter.extensions.commonCatch
import com.zy.starter.network.ApiErrors
import com.zy.starter.network.ApiException
import com.zy.starter.network.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

open class BaseRepository {

    protected suspend fun <T> request(
        apiCall: suspend () -> BaseResponse<T>,
        onSuccess: suspend (T) -> Unit
    ): Flow<Result<T>> {
        return flow {
            // 执行 Api 请求
            val response = apiCall()
            // 将 Api 请求结果封装成Result
            val result = if (response.isSuccessful()) {
                // code = 0 的情况，将响应体封装在Result.Success
                val data = response.data
                if (data != null) {
                    onSuccess(data)
                    Result.success(data)
                } else {
                    Result.failure(
                        ApiException(
                            ApiErrors.DATA_NULL_ERROR.code,
                            ApiErrors.DATA_NULL_ERROR.msg
                        )
                    )
                }
            } else {
                // 如果code != 0，将错误信息封装在Result.Error
                Result.failure(
                    ApiException(
                        response.code,
                        response.msg ?: ApiErrors.INTERNAL_ERROR.msg
                    )
                )
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}