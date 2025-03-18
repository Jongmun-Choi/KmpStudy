package com.dave.kmpstudy.network

import com.dave.kmpstudy.data.model.AccessToken
import com.dave.kmpstudy.data.model.AccessTokenRequestInfo

interface GithubApi {

    suspend fun getAccessToken(accessTokenRequestInfo: AccessTokenRequestInfo) : AccessToken
    suspend fun getUserList()

}