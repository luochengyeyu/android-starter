package com.zy.starter.api

import com.zy.starter.features.home.data.Banner
import com.zy.starter.features.user.data.UserApiModel
import com.zy.starter.network.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WanAndroidService {
    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<List<Banner>>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") password: String,
    ): BaseResponse<UserApiModel>
}