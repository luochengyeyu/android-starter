package com.zy.starter.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ApiCall {
    private const val BASE_URL = "https://www.wanandroid.com/"
    /**
     * 请求超时时间
     */
    private const val DEFAULT_TIMEOUT = 30000

    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(provideOkHttpClient())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        // 添加公共的拦截器、超时设置、证书验证等配置
        return OkHttpClient.Builder().run {
            connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            build()
        }
    }

    fun <T> create(apiService: Class<T>): T {
        return retrofit.create(apiService)
    }

}