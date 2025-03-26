package com.dave.kmpstudy.android.view.login


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dave.kmpstudy.android.R
import com.dave.kmpstudy.android.resource.Colors


@Composable
fun LoginScreen(
    loginProcess: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Colors.white)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ){
            Column{
                Icon(
                    modifier = Modifier.size(200.dp, 200.dp),
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.padding(top = 36.dp))

                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Colors.black)
                ) {
                    Text(
                        text = "Hello world!",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Colors.black)
                            .clickable(onClick = {
                                loginProcess()
                            }),
                        style = TextStyle(
                            color = Colors.white
                        ),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                }


            }

        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}