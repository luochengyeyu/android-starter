package com.zy.starter.network

class ApiException(code: Int, msg: String) : Exception(msg)

enum class ApiErrors(val code: Int, val msg: String) {
    NETWORK_ERROR(10001, "网络连接错误"),
    TIMEOUT_ERROR(10002, "请求超时"),
    INTERNAL_ERROR(10003, "服务器内部错误"),
    DATA_NULL_ERROR(10004, "服务器数据异常"),
    UNKNOWN_ERROR(20000, "未知错误")
}