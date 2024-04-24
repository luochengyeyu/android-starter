package com.zy.starter.network.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("data")
    val data: T?,
    @SerialName("errorCode")
    val code: Int,
    @SerialName("errorMsg")
    val msg: String?
) {
    fun isSuccessful() = code == 0
}
