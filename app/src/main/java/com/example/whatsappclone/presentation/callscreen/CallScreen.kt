package com.example.whatsappclone.presentation.callscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
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
fun CallScreen(navHostController: NavHostController) {

    val sampleCalls = listOf(
        CallItemData(
            image = R.drawable.karan,
            name = "Karan Mandhera",
            time = "Yesterday, 10:00 pm",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.karan,
            name = "Karan Mandhera",
            time = "Yesterday, 9:22 pm",
            isMissed = true
        ),
        CallItemData(
            image = R.drawable.ashish,
            name = "Ashish Bhardwaj",
            time = "Yesterday, 10:00 am",
            isMissed = true
        ),
        CallItemData(
            image = R.drawable.ajay,
            name = "Ajay Hooda Rohtak",
            time = "Yesterday, 11:55 am",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.kartik,
            name = "Kartik Grover",
            time = "28 February, 7:36 am",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.karan,
            name = "Karan Mandhera",
            time = "27 February, 9:03 am",
            isMissed = true
        ),
        CallItemData(
            image = R.drawable.karan,
            name = "Karan Mandhera",
            time = "27 February, 1:07 pm",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.gautam,
            name = "Gautam Soni",
            time = "26 February, 7:43 am",
            isMissed = true
        ),
        CallItemData(
            image = R.drawable.pardeep,
            name = "Pardeep Yadav",
            time = "26 February, 10:44 am",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.ajay,
            name = "Ajay Hooda Rohtak",
            time = "25 February, 8:37 pm",
            isMissed = false
        ),
        CallItemData(
            image = R.drawable.amit,
            name = "Amit Singla",
            time = "24 February, 11:33 pm",
            isMissed = true
        )

    )

    Scaffold(
        topBar = { TopBarCall() },
        bottomBar = {
            BottomNavigation(navHostController, selectedItem = 3, onClick = { index ->

                when (index) {
                    0 -> { navHostController.navigate(Routes.HomeScreen)}

                    1 -> { navHostController.navigate(Routes.UpdateScreen) }

                    2 -> { navHostController.navigate(Routes.CommunitiesScreen) }

                    3 -> { navHostController.navigate(Routes.CallScreen) }
                }
            })
        },

        floatingActionButton = {
            FloatingActionButton(
                {},
                containerColor = colorResource(R.color.light_green),
                modifier = Modifier.size(55.dp),
                contentColor = Color.White

            ) {
                Icon(
                    painter = painterResource(R.drawable.add_call), null,
                    modifier = Modifier
                        .size(28.dp)
                )
            }
        }
    ) {

        LazyColumn(modifier = Modifier.fillMaxSize().padding(it) ){

            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { FavouriteSection() }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.light_green)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Start a new community",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Text(
                    text = "Recent Calls", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            items(sampleCalls) { data ->
                CallItemDesign(data)
            }
        }

    }
}

