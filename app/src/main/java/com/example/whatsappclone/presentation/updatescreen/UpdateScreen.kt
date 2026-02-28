package com.example.whatsappclone.presentation.updatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.bottomnavigation.BottomNavigation
import com.example.whatsappclone.presentation.navigation.Routes

@Composable
fun UpdateScreen(navHostController: NavHostController) {

    val scrollState = rememberScrollState()

    var sampleStatus = listOf(
        StatusData(
            image = R.drawable.ajaykumar,
            name = "Ajay Hooda Rohtak",
            time = "Just now"
        ),
        StatusData(
            image = R.drawable.buggati,
            name = "Ankit Kumar",
            time = "10 min ago"
        ),
        StatusData(
            image = R.drawable.profile,
            name = "Narender Gurra",
            time = "29 min ago"
        ),
        StatusData(
            image = R.drawable.bmw,
            name = "Pardeep Yadav",
            time = "1 hour ago"
        ),
        StatusData(
            image = R.drawable.man,
            name = "Parvesh",
            time = "12:43 pm"
        ),
        StatusData(
            image = R.drawable.buggati,
            name = "Aman Boora",
            time = "Yesterday"
        ),
    )

    val sampleChannel = listOf(
            ChannelData(
                image = R.drawable.netflix,
                name = "Netflix",
                description = "32.2M followers"
            ),
        ChannelData(
            image = R.drawable.meta,
            name = "Meta",
            description = "8K followers"
        ),
        ChannelData(
            image = R.drawable.whatsapp_icon,
            name = "WhatsApp",
            description = "231M followers"
        ),
        ChannelData(
            image = R.drawable.instagram,
            name = "Instagram",
            description = "126K followers"
        ),
        ChannelData(
            image = R.drawable.spotify,
            name = "Spotify",
            description = "11M followers"
        )
    )

    Scaffold(

        bottomBar = {
            BottomNavigation(navHostController, selectedItem = 1, onClick = { index ->

                when (index) {
                    0 -> { navHostController.navigate(Routes.HomeScreen)}

                    1 -> { navHostController.navigate(Routes.UpdateScreen) }

                    2 -> { navHostController.navigate(Routes.CommunitiesScreen) }

                    3 -> { navHostController.navigate(Routes.CallScreen) }
                }
            })
        },
        topBar = { TopBar() },
        floatingActionButton = {
            FloatingActionButton(
                {},
                containerColor = colorResource(R.color.light_green),
                modifier = Modifier.size(55.dp),
                contentColor = Color.White

            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_photo_camera_24), null,
                    modifier = Modifier
                        .size(28.dp)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
            )

            MyStatus()

            sampleStatus.forEach {
                StatusItem(statusData = it)
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = Color.Gray)

            Text(
                text = "Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Stay updated on topics that matter to you. Find channel to follow below.")

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Find channels to follow")
            }

            Spacer(modifier = Modifier.height(16.dp))

            sampleChannel.forEach {
                ChannelItemDesign(channelData = it)
            }

        }
    }
}
