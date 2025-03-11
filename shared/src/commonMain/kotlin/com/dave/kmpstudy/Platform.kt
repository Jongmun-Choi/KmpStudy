package com.dave.kmpstudy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform