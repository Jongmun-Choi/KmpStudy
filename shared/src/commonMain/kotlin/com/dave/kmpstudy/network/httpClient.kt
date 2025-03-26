package com.dave.kmpstudy.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.*
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.annotation.Single
import org.koin.mp.KoinPlatform.getKoin

@OptIn(KoinInternalApi::class)
@Single
fun getHttpClient() = HttpClient(CIO) {
    expectSuccess = true

    defaultRequest {
        header("Accept", "application/json")
        header("content-type", "application/json")
//        header("Authorization", "Bearer ${}")
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                getKoin().logger.debug("logger Ktor => $message")
            }
        }
        level = LogLevel.ALL
    }

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            }
        )
    }

    install(ResponseObserver) {
        onResponse { response ->
            getKoin().logger.debug("Http status: ${response.status.value}")
        }
    }
    install(HttpCache)

    install(HttpTimeout) {
        requestTimeoutMillis = 10000L
        connectTimeoutMillis = 10000L
        socketTimeoutMillis = 10000L
    }


}