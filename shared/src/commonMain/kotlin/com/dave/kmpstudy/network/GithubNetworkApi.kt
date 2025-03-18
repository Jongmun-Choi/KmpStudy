package com.dave.kmpstudy.network

import com.dave.kmpstudy.data.model.AccessToken
import com.dave.kmpstudy.data.model.AccessTokenRequestInfo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Single

@Single
class GithubNetworkApi(private val httpClient: HttpClient) : GithubApi{

    val AUTH_BASE_API_URL = "https://github.com"
    val GITHUB_BASE_API_URL = "https://api.github.com"

    override suspend fun getAccessToken(accessTokenRequestInfo: AccessTokenRequestInfo): AccessToken {
        val url = "${AUTH_BASE_API_URL}/login/oauth/access_token"
        return try {
            val result = httpClient.post(url) {
                contentType(ContentType.Application.Json)
                setBody(accessTokenRequestInfo)
            }
            result.body()
        } catch (e: Exception) {
            AccessToken("${e.message}")
        }
    }

    override suspend fun getUserList() {

    }
}