package com.zy.starter

import android.app.Application
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

        fun get(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        LoadingStateView.setViewDelegatePool {
            register(
                ToolbarViewDelegate(),
                LoadingViewDelegate(),
                ErrorViewDelegate(),
                EmptyViewDelegate(),
            )
        }
    }
}