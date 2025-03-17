package com.dave.kmpstudy.android.utils

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.dave.kmpstudy.android.BuildConfig
import com.dave.kmpstudy.data.model.AccessToken
import androidx.core.content.edit
import com.dave.kmpstudy.android.KmpStudyApplication.Companion.context

object EncryptedSharedPreferencesHelper {
    private val masterKeyAlias = MasterKey
        .Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
    private val tokenSharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        BuildConfig.Shared_Preference_Name,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun setToken(tokenInfo : AccessToken) {
        tokenSharedPreferences.edit() { putString("accessToken", tokenInfo.accessToken) }
    }

    fun getToken() : String? {
        return tokenSharedPreferences.getString("accessToken", "")
    }
}