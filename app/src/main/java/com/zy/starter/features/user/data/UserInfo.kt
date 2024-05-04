package com.zy.starter.features.user.data

data class UserInfo(
    val id: Int,
    val username: String,
    val nickname: String,
    val email: String,
    val coinCount: Int
)