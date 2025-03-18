package com.dave.kmpstudy.android

import android.app.Application
import com.dave.kmpstudy.android.di.viewModelModule
import com.dave.kmpstudy.di.AppModule
import com.dave.kmpstudy.di.DataModule
import com.dave.kmpstudy.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class GithubApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        startKoin {
            androidContext(this@GithubApp)
            modules(
                listOf(
                    AppModule().module,
                    DataModule().module,
                    NetworkModule().module,
                    viewModelModule()
                )
            )
        }
    }

    companion object {
        lateinit var context: Application
            private set
    }

}