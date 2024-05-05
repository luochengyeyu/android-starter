package com.zy.starter.di

import com.zy.starter.api.WanAndroidService
import com.zy.starter.network.RetrofitClient
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
        return RetrofitClient.create(WanAndroidService::class.java)
    }
}