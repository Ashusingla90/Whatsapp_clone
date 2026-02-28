package com.example.whatsappclone.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.whatsappclone.R
import com.example.whatsappclone.viewmodel.BaseViewModel

@Composable
fun AddUserPopup(
    onDismiss: () -> Unit,
    onUserAdd: (ChatListModel) -> Unit,
    baseViewModel: BaseViewModel

) {

    var phoneNumber by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    var userFound by remember { mutableStateOf<ChatListModel?>(null) }
    var hasSearched by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Enter phone number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )

        Row() {
            Button(
                onClick = {
                    isSearching = true
                    hasSearched = true
                    baseViewModel.searchUserByPhoneNumber(phoneNumber) { user ->
                        isSearching = false

                        if (user != null) {
                            userFound = user
                        } else {
                            userFound = null
                        }

                    }
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.light_green))
            ) {
                Text("Search")

            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onDismiss,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.light_green)
                )
            ) {
                Text("Cancel")
            }
            if (isSearching) {
                Text("Searching...", color = Color.Gray)
            }

            userFound?.let {
                Column() {
                    Text("User Found: ${it.name}")

                    Button(
                        onClick = {
                            onUserAdd(it)

                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            colorResource(R.color.light_green)
                        )
                    ) {
                        Text("Add to Chat")
                    }
                }
            } ?: run {

                if(hasSearched && !isSearching){
                    Text("User not found", color = Color.Red)
                }
            }


        }


    }
}