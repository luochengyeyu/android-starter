package com.zy.starter.features.user.data

import com.zy.starter.api.WanAndroidService
import com.zy.starter.base.BaseRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val service: WanAndroidService) :
    BaseRepository() {
    suspend fun login(username: String, password: String): Flow<Result<UserApiModel>> {
        return request(
            {
                delay(3000)
                // 执行登录请求
                service.login(username, password)
            }, {
                // 登录成功，保存用户信息
            }
        )
    }
}