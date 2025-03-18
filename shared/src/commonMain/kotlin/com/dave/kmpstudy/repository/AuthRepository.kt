package com.dave.kmpstudy.repository

import com.dave.kmpstudy.data.model.AccessToken
import com.dave.kmpstudy.data.model.AccessTokenRequestInfo
import com.dave.kmpstudy.network.GithubApi
import org.koin.core.annotation.Single

@Single
class AuthRepository constructor(private val GithubApi: GithubApi) {
    suspend fun getAccessToken(accessTokenRequestInfo: AccessTokenRequestInfo): AccessToken {
        return GithubApi.getAccessToken(accessTokenRequestInfo)
    }
}