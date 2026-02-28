package com.example.whatsappclone.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.navigation.Routes
import com.example.whatsappclone.presentation.bottomnavigation.BottomNavigation
import com.example.whatsappclone.viewmodel.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navHostController: NavHostController, homeBaseViewModel: BaseViewModel) {

    var showPopup by remember {
        mutableStateOf(false)
    }

    val chatData by homeBaseViewModel.chatList.collectAsState()
    val userId = FirebaseAuth.getInstance().currentUser?.uid

    if (userId != null) {
        LaunchedEffect(userId) {
            homeBaseViewModel.getChatForUser(userId) { chats ->

            }
        }
    }

    var showMenu by remember { mutableStateOf(false) }


    val dummyData = listOf(
        ChatListModel(
            image1 = R.drawable.ashu,
            name = "Ashu Singla",
            time = "10:00 AM",
            message = "Haryana"
        ),
        ChatListModel(
            image1 = R.drawable.karan,
            name = "Karan Mandhera",
            time = "09:00 AM",
            message = "👍"
        ),
        ChatListModel(
            image1 = R.drawable.ashish,
            name = "Ashish Bhardwaj",
            time = "08:55 AM",
            message = "Gate 2026"
        ),
        ChatListModel(
            image1 = R.drawable.gautam,
            name = "Gautam Soni",
            time = "09:00 AM",
            message = "Arr na"
        ),
        ChatListModel(
            image1 = R.drawable.ajay,
            name = "Ajay Hooda Rohtak",
            time = "11:03 PM",
            message = "Angel one"
        ),
        ChatListModel(
            image1 = R.drawable.pardeep,
            name = "Pardeep Yadav Mac",
            time = "10:51 PM",
            message = "Roll 25"
        ),
        ChatListModel(
            image1 = R.drawable.amit,
            name = "Amit Singla",
            time = "10:43 PM",
            message = "Okay bhai"
        ),
        ChatListModel(
            image1 = R.drawable.kartik,
            name = "Kartik Grover",
            time = "11:57 PM",
            message = "Os ka question bhej da bhai"
        ),
        ChatListModel(
            image1 = R.drawable.profile,
            name = "Ankush Kumar",
            time = "10:01 PM",
            message = "hello"
        ),
        ChatListModel(
            image1 = R.drawable.ajaykumar,
            name = "Ajay Kumar",
            time = "09:47 PM",
            message = "hii"
        ),
        ChatListModel(
            image1 = R.drawable.ashu,
            name = "Ashu Singla",
            time = "10:00 AM",
            message = "Haryana"
        ),
        ChatListModel(
            image1 = R.drawable.karan,
            name = "Karan Mandhera",
            time = "09:00 AM",
            message = "👍"
        ),
        ChatListModel(
            image1 = R.drawable.ashish,
            name = "Ashish Bhardwaj",
            time = "08:55 AM",
            message = "Gate 2026"
        ),
        ChatListModel(
            image1 = R.drawable.gautam,
            name = "Gautam Soni",
            time = "09:00 AM",
            message = "Arr na"
        ),
        ChatListModel(
            image1 = R.drawable.ajay,
            name = "Ajay Hooda Rohtak",
            time = "11:03 PM",
            message = "Angel one"
        ),
        ChatListModel(
            image1 = R.drawable.pardeep,
            name = "Pardeep Yadav Mac",
            time = "10:51 PM",
            message = "Roll 25"
        ),
        ChatListModel(
            image1 = R.drawable.amit,
            name = "Amit Singla",
            time = "10:43 PM",
            message = "Okay bhai"
        ),
        ChatListModel(
            image1 = R.drawable.kartik,
            name = "Kartik Grover",
            time = "11:57 PM",
            message = "Os ka question bhej da bhai"
        ),
        ChatListModel(
            image1 = R.drawable.profile,
            name = "Ankush Kumar",
            time = "10:01 PM",
            message = "hello"
        ),
        ChatListModel(
            image1 = R.drawable.ajaykumar,
            name = "Ajay Kumar",
            time = "09:47 PM",
            message = "hii"
        )
    )

    val chatData1 = if (chatData.isEmpty()) dummyData else chatData

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showPopup = true
                },
                containerColor = colorResource(R.color.light_green),
                contentColor = Color.White,
                modifier = Modifier.size(54.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.add_chat_icon), null,
                    modifier = Modifier
                        .size(28.dp)
                        .rotate(90f)
                )
            }
        }, bottomBar = {
            BottomNavigation(navHostController, selectedItem = 0, onClick = { index ->

                when (index) {
                    0 -> {
                        navHostController.navigate(Routes.HomeScreen)
                    }

                    1 -> {
                        navHostController.navigate(Routes.UpdateScreen)
                    }

                    2 -> {
                        navHostController.navigate(Routes.CommunitiesScreen)
                    }

                    3 -> {
                        navHostController.navigate(Routes.CallScreen)
                    }
                }
            })
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .background(color = Color.White)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                var isSearching by remember { mutableStateOf(false) }
                var searchText by remember { mutableStateOf("") }
                var showMenu by remember { mutableStateOf(false) }

                if (isSearching) {
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = { Text("Search", color = Color.Gray) },
                        singleLine = true,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp)
                            .fillMaxWidth(0.8f),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent
                        )
                    )

                    IconButton(
                        onClick = {
                            isSearching = false
                            searchText = ""
                        },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.cross),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                } else {
                    Text(
                        text = "WhatsApp",
                        fontSize = 28.sp,
                        color = colorResource(R.color.light_green),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    )

                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.camera), null,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        IconButton(onClick = { isSearching = true }) {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
//
//                        if (isSearching) {
//                            IconButton(onClick = {
//                                isSearching = false
//                                searchText = ""
//                            }) {
//                                Icon(
//                                    painter = painterResource(R.drawable.cross), null,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                            }
//                        } else {
//                            IconButton(onClick = {
//                                isSearching = true
//                            }) {
//                                Icon(
//                                    painter = painterResource(R.drawable.search), null,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                            }
//                        }

                        Box() {

                            IconButton(onClick = {
                                showMenu = !showMenu
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.more), null,
                                    modifier = Modifier.size(24.dp)
                                )

                                DropdownMenu(
                                    expanded = showMenu, onDismissRequest = {
                                        showMenu = false
                                    },
                                    modifier = Modifier.background(color = Color.White)
                                ) {

                                    DropdownMenuItem(
                                        text = { Text("New group") },
                                        onClick = { showMenu = false })
                                    DropdownMenuItem(
                                        text = { Text("New community") },
                                        onClick = { showMenu = false })
                                    DropdownMenuItem(
                                        text = { Text("Broadcast lists") },
                                        onClick = { showMenu = false })
                                    DropdownMenuItem(
                                        text = { Text("Linked devices") },
                                        onClick = { showMenu = false })
                                    DropdownMenuItem(
                                        text = { Text("Starred") },
                                        onClick = { showMenu = false })
                                    DropdownMenuItem(text = { Text("Settings") }, onClick = {
                                        showMenu = false

                                        navHostController.navigate(Routes.SettingScreen)
                                    })
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()

            Spacer(modifier = Modifier.height(12.dp))


            if (showPopup) {
                AddUserPopup(
                    onDismiss = { showPopup = false }, onUserAdd = { newUser ->
                        homeBaseViewModel.addChat(newUser)
                    },
                    baseViewModel = homeBaseViewModel
                )
            }

            LazyColumn() {
                items(chatData1) { chat ->
                    ChatListBox(chatListModel = chat, onClick = {
                        navHostController.navigate(
                            Routes.ChatScreen.createRoutes(
                                phoneNumber = chat.phoneNumber ?: "ok"
                            )
                        )
                    }, baseViewModel = homeBaseViewModel)
                }
            }
        }
    }
}


//
//@Composable
//fun HomeScreen1() {
//
//    val chatData = listOf(
//        ChatListModel(
//            image = R.drawable.ashu,
//            name = "Ashu Singla",
//            time = "10:00 AM",
//            message = "Haryana"
//        ),
//
//        ChatListModel(
//            image = R.drawable.karan,
//            name = "Karan Mandhera",
//            time = "09:00 AM",
//            message = "Done"
//        ),
//
//        ChatListModel(
//            image = R.drawable.ashish,
//            name = "Ashish Bhardwaj",
//            time = "08:55 AM",
//            message = "Gate 2026"
//        ),
//        ChatListModel(
//            image = R.drawable.gautam,
//            name = "Gautam Soni",
//            time = "09:00 AM",
//            message = "Arr na"
//        ),
//
//
//        ChatListModel(
//            image = R.drawable.ajay,
//            name = "Ajay Hooda Rohtak",
//            time = "11:03 PM",
//            message = "Angel one"
//        ),
//        ChatListModel(
//            image = R.drawable.pardeep,
//            name = "Pardeep Yadav Mac",
//            time = "10:51 PM",
//            message = "Roll 25"
//        ),
//
//        ChatListModel(
//            image = R.drawable.amit,
//            name = "Amit Singla",
//            time = "10:43 PM",
//            message = "Okay bhai"
//        ),
//        ChatListModel(
//            image = R.drawable.kartik,
//            name = "Kartik Grover",
//            time = "11:57 PM",
//            message = "Os ka question bhej da bhai"
//        ),
//        ChatListModel(
//            image = R.drawable.profile,
//            name = "Ankush Kumar",
//            time = "10:01 PM",
//            message = "hello "
//        ),
//        ChatListModel(
//            image = R.drawable.ajaykumar,
//            name = "Ajay Kumar",
//            time = "09:47 PM",
//            message = "hii"
//        ),
//        ChatListModel(
//            image = R.drawable.ashu,
//            name = "Ashu Singla",
//            time = "10:00 AM",
//            message = "Haryana"
//        ),
//
//        ChatListModel(
//            image = R.drawable.karan,
//            name = "Karan Mandhera",
//            time = "09:00 AM",
//            message = "Done"
//        ),
//
//        ChatListModel(
//            image = R.drawable.ashish,
//            name = "Ashish Bhardwaj",
//            time = "08:55 AM",
//            message = "Gate 2026"
//        ),
//        ChatListModel(
//            image = R.drawable.gautam,
//            name = "Gautam Soni",
//            time = "09:00 AM",
//            message = "Arr na"
//        ),
//
//
//        ChatListModel(
//            image = R.drawable.ajay,
//            name = "Ajay Hooda Rohtak",
//            time = "11:03 PM",
//            message = "Angel one"
//        ),
//
//
//        ChatListModel(
//            image = R.drawable.amit,
//            name = "Amit Singla",
//            time = "10:43 PM",
//            message = "Okay bhai"
//        ),
//        ChatListModel(
//            image = R.drawable.kartik,
//            name = "Kartik Grover",
//            time = "11:57 PM",
//            message = "Os ka question bhej da bhai"
//        ),
//        ChatListModel(
//            image = R.drawable.profile,
//            name = "Ankush Kumar",
//            time = "10:01 PM",
//            message = "hello "
//        ),
//        ChatListModel(
//            image = R.drawable.ajaykumar,
//            name = "Ajay Kumar",
//            time = "09:47 PM",
//            message = "hii"
//        )
//
//
//    )
//
//
//
//            HorizontalDivider()
//
//            LazyColumn() {
//                items(chatData) {
//                    ChatListBox(chatListModel = it)
//                }
//            }
//
//        }
//    }
//}