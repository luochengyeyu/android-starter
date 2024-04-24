package com.zy.starter.network

import com.zy.starter.MyApp
import com.zy.starter.extensions.toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T> Flow<T>.commonCatch(action: suspend FlowCollector<T>.(cause: Throwable) -> Unit): Flow<T> {
    return this.catch {
        if (it is UnknownHostException || it is SocketTimeoutException) {
            MyApp.get().toast("发生网络错误，请稍后重试")
        } else {
            MyApp.get().toast("请求失败，请重试")
        }
        action(it)
    }
}