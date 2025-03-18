package com.dave.kmpstudy.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenRequestInfo(
    val client_id : String,
    val client_secret : String,
    val code : String
)