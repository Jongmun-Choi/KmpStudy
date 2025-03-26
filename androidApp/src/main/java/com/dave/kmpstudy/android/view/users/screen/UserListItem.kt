package com.dave.kmpstudy.android.view.users.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import com.dave.kmpstudy.data.model.User
import com.skydoves.landscapist.glide.GlideImage
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserListItem(
    user : User
) {
    Row {
        GlideImage(
            imageModel = user.avatarUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(54.dp)
        )
        Column {
            Text(user.name)
            Text(user.repoUrl)
        }

    }
}