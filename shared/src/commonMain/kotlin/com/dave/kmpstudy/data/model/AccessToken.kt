package com.dave.kmpstudy.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    val accessToken : String
)