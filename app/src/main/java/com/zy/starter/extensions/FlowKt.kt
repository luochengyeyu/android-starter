package com.zy.starter.extensions

import com.dylanc.longan.toast
import com.zy.starter.App
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T> Flow<T>.commonCatch(action: suspend FlowCollector<T>.(cause: Throwable) -> Unit): Flow<T> {
    return this.catch {
        when (it) {
            is UnknownHostException -> {
                App.get().toast("网络连接失败，请检查网络")
            }

            is SocketTimeoutException -> {
                App.get().toast("网络连接超时，请检查网络")
            }

            else -> {
                App.get().toast("未知错误")
            }
        }
        action(it)
    }
}