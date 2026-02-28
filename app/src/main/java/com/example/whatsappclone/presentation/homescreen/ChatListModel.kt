package com.example.whatsappclone.presentation.homescreen

import android.graphics.Bitmap

data class ChatListModel (
    val name: String? = null,
    val phoneNumber: String? = null,
    val image: Bitmap? = null,
    val image1: Int? = null,
    val userId: String? = null,
    val time: String? = null,
    val message: String? = null,
    val profileImage: String? = null
){
    constructor(): this(null,null,null,null,null,null,null)
}