package com.dave.kmpstudy.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.dave.kmpstudy.android.view.login.LoginScreen
import com.dave.kmpstudy.android.view.users.UserListActivity
import com.dave.kmpstudy.android.viewmodel.LoginViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCollection()
        setContent {
            MyApplicationTheme {
                LoginScreen(
                    loginProcess = {
                        clickLogin()
                    }
                )
            }
        }
    }

    private fun setCollection() {
        lifecycleScope.launch {
            viewModel.loginSuccess.collect { isLoginSuccess ->
                if(isLoginSuccess) {
                    startActivity(Intent(this@MainActivity, UserListActivity::class.java))
                }
            }
        }
    }

    private fun clickLogin() {
        val loginUrl = Uri.Builder().scheme("https").authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("client_id", BuildConfig.clientId)
            .build()

        CustomTabsIntent.Builder().build().also {
            it.launchUrl(this, loginUrl)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        intent.data?.getQueryParameter("code")?.let(viewModel::getAccessToken)
    }

}


@Preview
@Composable
fun MainActivityPreview() {
    LoginScreen(loginProcess = {})
}