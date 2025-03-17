package com.dave.kmpstudy.android

import android.app.Application

class KmpStudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: Application
            private set
    }

}