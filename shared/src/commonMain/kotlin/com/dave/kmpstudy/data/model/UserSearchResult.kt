package com.dave.kmpstudy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSearchResult(
    @SerialName("incomplete_results")
    val isFinish: Boolean,
    @SerialName("items")
    val users: List<User>
)
