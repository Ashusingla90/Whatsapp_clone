package com.example.whatsappclone.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(2000)
        navHostController.navigate(Routes.WelcomeScreen){
            popUpTo(Routes.SplashScreen){
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {

        Image(
            painter = painterResource(R.drawable.whatsapp_icon), null,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "From", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Row() {
                Icon(
                    painter = painterResource(R.drawable.meta), null,
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(R.color.light_green)
                )

                Spacer(modifier = Modifier.size(6.dp))

                Text(
                    text = "Meta", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.light_green)
                )
            }
        }
    }

}
//
//@Preview(showSystemUi = true)
//@Composable
//private fun SplashPrev() {
//    SplashScreen()
//}