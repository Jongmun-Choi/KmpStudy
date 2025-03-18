package com.dave.kmpstudy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id : Int,
    @SerialName("login")
    val name: String,
    @SerialName("avatar_url")
    val avatarUrl : String,
    @SerialName("html_url")
    val repoUrl : String
)