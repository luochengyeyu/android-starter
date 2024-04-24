package com.zy.starter.features.wanandroid

import com.zy.starter.network.base.BaseResponse
import retrofit2.http.GET

interface WanAndroidApi {
    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<List<Banner>>
}