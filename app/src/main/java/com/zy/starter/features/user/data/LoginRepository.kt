package com.zy.starter.features.user.data

import com.zy.starter.api.WanAndroidService
import com.zy.starter.base.BaseRepository
import com.zy.starter.network.ApiClient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val service: WanAndroidService) :
    BaseRepository() {
    suspend fun login(username: String, password: String): Flow<Result<UserApiModel>> {
        return request {
            service.login(username, password)
        }
    }
}