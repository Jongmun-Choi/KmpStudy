package com.dave.kmpstudy.network

import io.ktor.client.HttpClient
import org.koin.core.annotation.Single

@Single
class GithubNetworkApi(private val httpClient: HttpClient) {
}