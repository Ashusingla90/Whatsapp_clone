package com.example.whatsappclone.presentation.communitiesscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.bottomnavigation.BottomNavigation
import com.example.whatsappclone.presentation.navigation.Routes

@Composable
fun CommunitiesScreen(navHostController: NavHostController) {

    val sampleCommunities = listOf(
        CommunityData(
            image = R.drawable.img,
            name = "Tech Enthusiast",
            members = "256 members"
        ),
        CommunityData(
            image = R.drawable.defender,
            name = "Defender",
            members = "17.2K members"
        ),
        CommunityData(
            image = R.drawable.buggati,
            name = "Buggati",
            members = "25K members"
        ),
        CommunityData(
            image = R.drawable.ajaykumar,
            name = "BMW",
            members = "2.4M members"
        ),

        )

    Scaffold(
        topBar = {
            TopBarCommunity()
        },

        bottomBar = {
            BottomNavigation(navHostController, selectedItem = 2, onClick = { index ->

                when (index) {
                    0 -> { navHostController.navigate(Routes.HomeScreen)}

                    1 -> { navHostController.navigate(Routes.UpdateScreen) }

                    2 -> { navHostController.navigate(Routes.CommunitiesScreen) }

                    3 -> { navHostController.navigate(Routes.CallScreen) }
                }
            })
        }) {
        Column(modifier = Modifier.padding(it)) {

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.light_green)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Start a new community", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your Communities", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn() {
                items(sampleCommunities) {
                    CommunityItemDesign(it)
                }
            }
        }
    }
}

