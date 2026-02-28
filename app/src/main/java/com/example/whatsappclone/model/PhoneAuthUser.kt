package com.example.whatsappclone.model

data class PhoneAuthUser(
    val uid: String = "",
    val name: String = "",
    val phoneNumber: String = "",
    val displayName: String = "",
    val status: String = "",
    val profileImage: String? = null

)