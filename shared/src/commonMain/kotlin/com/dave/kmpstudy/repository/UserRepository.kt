package com.dave.kmpstudy.repository

import com.dave.kmpstudy.network.GithubApi
import org.koin.core.annotation.Single

@Single
class UserRepository constructor(private val GithubApi: GithubApi) {
    suspend fun searchUserList(query : String, page : Int) = GithubApi.getUserList(query, page)
}