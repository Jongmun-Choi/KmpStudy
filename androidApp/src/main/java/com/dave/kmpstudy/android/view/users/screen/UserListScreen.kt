package com.dave.kmpstudy.android.view.users.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.Pager
import com.dave.kmpstudy.android.resource.Colors
import com.dave.kmpstudy.android.viewmodel.UserListViewModel
import com.dave.kmpstudy.data.model.User

@Composable
fun UserListScreen(
    userListViewModel: UserListViewModel

) {

    val userList : List<User> by userListViewModel.userList.collectAsStateWithLifecycle()

    val lazyListState = rememberLazyListState()

    userListViewModel.getUserList("test")

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Colors.white),
        state = lazyListState,
    ) {
        itemsIndexed(userList) { index, user ->
            UserListItem(user)
            println("index : $index")
            if(index == userList.lastIndex){
                userListViewModel.getUserList("test")
            }
        }
    }



}