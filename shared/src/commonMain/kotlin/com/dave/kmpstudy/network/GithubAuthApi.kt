package com.dave.kmpstudy.network

interface GithubAuthApi {

    suspend fun getAccessToken()
    suspend fun getUserList()

}