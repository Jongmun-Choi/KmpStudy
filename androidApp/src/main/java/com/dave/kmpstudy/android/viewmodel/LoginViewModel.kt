package com.dave.kmpstudy.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dave.kmpstudy.android.utils.EncryptedSharedPreferencesHelper
import com.dave.kmpstudy.data.model.AccessTokenRequestInfo
import com.dave.kmpstudy.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import java.net.SocketTimeoutException
import java.net.UnknownHostException

@KoinViewModel
class LoginViewModel constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val clientId = "Ov23lic4V0Q63ZTvg1j4"
    private val clientSecretKey = "8310b2ef65d919da55704a87b32681fe2952fe9b"

    private val _isLoginSuccess = MutableStateFlow(false)
    val loginSuccess : StateFlow<Boolean> = _isLoginSuccess

    fun getAccessToken(code : String) {
        val accessTokenRequestInfo = AccessTokenRequestInfo(clientId, clientSecretKey, code)
        viewModelScope.launch {
            try {
                val result = repository.getAccessToken(accessTokenRequestInfo)
                if(result.accessToken.isNotEmpty()) {
                    println("result : $result")
                    EncryptedSharedPreferencesHelper.setToken(result)
                    _isLoginSuccess.emit(true)
                }

            } catch (e: UnknownHostException) {
                e.printStackTrace()
            } catch (e: SocketTimeoutException) {
                e.printStackTrace()
            }
        }

    }

}