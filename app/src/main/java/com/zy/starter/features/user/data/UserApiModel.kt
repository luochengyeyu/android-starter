package com.zy.starter.features.user.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserApiModel(
    @SerialName("admin")
    val admin: Boolean,
    @SerialName("chapterTops")
    val chapterTops: List<Int>,
    @SerialName("coinCount")
    val coinCount: Int,
    @SerialName("collectIds")
    val collectIds: List<Int>,
    @SerialName("email")
    val email: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("id")
    val id: Int,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("password")
    val password: String,
    @SerialName("publicName")
    val publicName: String,
    @SerialName("token")
    val token: String,
    @SerialName("type")
    val type: Int,
    @SerialName("username")
    val username: String
)

fun UserApiModel.toUserInfo(): UserInfo {
    return UserInfo(
        id = id,
        username = username,
        nickname = nickname,
        email = email,
        coinCount = coinCount
    )
}