package com.zy.starter

import android.app.Application
import android.content.Context
import android.os.Build
import coil.Coil
import coil.ImageLoader
import com.dylanc.loadingstateview.LoadingStateView
import com.zy.starter.library.loadingstateview.EmptyViewDelegate
import com.zy.starter.library.loadingstateview.ErrorViewDelegate
import com.zy.starter.library.loadingstateview.LoadingViewDelegate
import com.zy.starter.library.loadingstateview.ScrollingDecorViewDelegate
import com.zy.starter.library.loadingstateview.ToolbarViewDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        fun get(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initCoil(this)
        LoadingStateView.setViewDelegatePool {
            register(
                ToolbarViewDelegate(),
                LoadingViewDelegate(),
                ErrorViewDelegate(),
                EmptyViewDelegate(),
            )
        }
    }

    private fun initCoil(context: Context) {
        val imageLoader = ImageLoader.Builder(context = context).build()
        Coil.setImageLoader(imageLoader)
    }
}