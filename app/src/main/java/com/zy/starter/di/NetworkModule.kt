package com.zy.starter.di

import com.zy.starter.api.WanAndroidService
import com.zy.starter.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideWanAndroidService(): WanAndroidService {
        return ApiClient.create(WanAndroidService::class.java)
    }
}