package com.example.myjetpackfront.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myjetpackfront.ui.theme.MyJetpackFrontTheme
import com.example.myjetpackfront.R
import com.example.myjetpackfront.data.user.User
import com.example.myjetpackfront.navigation.AppRouter
import com.example.myjetpackfront.navigation.ButtonHandler
import com.example.myjetpackfront.navigation.Screens


@Composable
fun ProfileScreen(
    userInfo: User,
    modifier: Modifier = Modifier
) {
    // Здесь можете разместить код для отображения содержимого профиля
    // Например:
    userInfo.name?.let { Text(it) }
    Image(
        painter = painterResource(id = R.drawable.profile_image),
        contentDescription = null,
        modifier = Modifier.size(200.dp)
    )
    ButtonHandler {
        AppRouter.navigateTo(Screens.HomeScreens)
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MyJetpackFrontTheme {
        ProfileScreen(
            userInfo = User("SomeName", arrayListOf("asd", "adasd"))
        )
    }
}
