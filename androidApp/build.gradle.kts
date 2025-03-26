plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.dave.kmpstudy.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.dave.kmpstudy.android"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {

        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isShrinkResources = false
            isMinifyEnabled = false

            buildConfigField("String","clientId", "\"Ov23lic4V0Q63ZTvg1j4\"")
            buildConfigField("String", "clientSecret", "\"8310b2ef65d919da55704a87b32681fe2952fe9b\"")
            buildConfigField("String", "Shared_Preference_Name", "\"TokenInfo\"")
        }

        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.foundation.layout.android)



    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)


    // Coil
    implementation(libs.coil.compose)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.paging.common.android)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
    debugImplementation(libs.ui.tooling)

    // EncryptedSharedPreferences
    implementation(libs.androidx.security.crypto.ktx)

    //Glide
    implementation(libs.landscapist.glide)


}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
