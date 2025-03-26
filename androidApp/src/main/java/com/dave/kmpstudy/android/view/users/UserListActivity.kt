package com.dave.kmpstudy.android.view.users

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.dave.kmpstudy.android.MyApplicationTheme
import com.dave.kmpstudy.android.view.users.screen.UserListScreen
import com.dave.kmpstudy.android.viewmodel.UserListViewModel

class UserListActivity : ComponentActivity() {

    private val userViewModel : UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                UserListScreen(userViewModel)
            }
        }
    }
}