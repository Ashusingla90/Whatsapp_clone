package com.example.whatsappclone.presentation.userregistrationscreen

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.navigation.Routes
import com.example.whatsappclone.viewmodel.AuthState
import com.example.whatsappclone.viewmodel.PhoneAuthViewModel

@Composable
fun UserRegistrationScreen(
    navController: NavController, phoneAuthViewModel: PhoneAuthViewModel = hiltViewModel()
) {

    var expanded by remember { mutableStateOf(false) }

    var selectedCountry by remember { mutableStateOf("India") }

    var countryCode by remember { mutableStateOf("+91") }
    var phoneNumber by remember { mutableStateOf("") }

    val authState by phoneAuthViewModel.authState.collectAsState()
    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    var otp by remember { mutableStateOf("") }
    var verificationId by remember { mutableStateOf<String?>(null) }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .statusBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Enter your phone number",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.dark_green)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row() {
            Text(text = "WhatsApp will need to verify your phone number. ", fontSize = 12.sp)

            Text(text = "What's", fontSize = 12.sp, color = colorResource(R.color.dark_green))
        }
        Text(text = "my number?", fontSize = 12.sp, color = colorResource(R.color.dark_green))

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.width(230.dp)) {
                Text(
                    text = selectedCountry,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    tint = colorResource(R.color.light_green)
                )
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    "India", "USA", "China", "Canada", "Australia", "Japan"
                ).forEach { country ->
                    DropdownMenuItem(text = { Text(text = country) }, onClick = {
                        selectedCountry = country
                        expanded = false
                    })
                }
            }
        }

//        HorizontalDivider(
//            modifier = Modifier.padding(horizontal = 66.dp),
//            thickness = 2.dp,
//            color = colorResource(R.color.light_green)
//        )


        when (authState) {
            is AuthState.Ideal, is AuthState.Loading, is AuthState.CodeSent -> {
                if (authState is AuthState.CodeSent) {
                    verificationId = (authState as AuthState.CodeSent).verificationId

                }

                if (verificationId == null) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = countryCode, onValueChange = { countryCode = it },
                            modifier = Modifier.width(70.dp),
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = colorResource(R.color.light_green),
                                focusedIndicatorColor = colorResource(R.color.light_green)
                            )
                        )

                        Spacer(modifier = Modifier.width(16.dp))


                        TextField(
                            value = phoneNumber, onValueChange = { phoneNumber = it },
                            placeholder = { Text(text = "Phone Number") },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,  // click karna ka bad bhi transparent hi dikha ga

                                unfocusedIndicatorColor = colorResource(R.color.light_green),
                                focusedIndicatorColor = colorResource(R.color.light_green)
                            ),
                            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),

                            )
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if (phoneNumber.isNotEmpty()) {
                                val fullPhoneNumber = "$countryCode$phoneNumber"
                                phoneAuthViewModel.sendVerificationCode(fullPhoneNumber, activity)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Please enter a valid phone number.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.dark_green))
                    ) {
                        Text(text = "Send OTP", fontSize = 16.sp)
                    }

                    if (authState is AuthState.Loading) {
                        Spacer(modifier = Modifier.height(16.dp))

                        CircularProgressIndicator()
                    }

                } else {

                    // OTP input UI
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Enter OTP",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.dark_green)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    TextField(
                        value = otp, onValueChange = { otp = it },
                        placeholder = { Text("OTP") },
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 48.dp, end = 48.dp),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,  // click karna ka bad bhi transparent hi dikha ga

                            unfocusedIndicatorColor = colorResource(R.color.light_green),
                            focusedIndicatorColor = colorResource(R.color.light_green)
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                            if (otp.isNotEmpty() && verificationId != null) {
                                phoneAuthViewModel.verifyCode(otp, context)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Please enter a valid OTP.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            colorResource(R.color.dark_green)
                        )
                    ) {
                        Text("Verify OTP")
                    }

                    if (authState is AuthState.Loading) {
                        Spacer(modifier = Modifier.height(16.dp))

                        CircularProgressIndicator()
                    }
                }

            }

            is AuthState.Success -> {
                Log.d("PhoneAuth", "LoginSuccessful")

                phoneAuthViewModel.resetAuthState()
                navController.navigate(Routes.UserProfileScreen) {

                    popUpTo<Routes.UserRegistrationScreen> {
                        inclusive = true
                    }
                }
            }

            is AuthState.Error -> {
                Toast.makeText(context, (authState as AuthState.Error).message, Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}

