package com.zy.starter.features.home.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    @SerialName("desc")
    val desc: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imagePath")
    val imagePath: String,
    @SerialName("isVisible")
    val isVisible: Int,
    @SerialName("order")
    val order: Int,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: Int,
    @SerialName("url")
    val url: String
)