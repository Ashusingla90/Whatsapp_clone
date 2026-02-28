package com.example.whatsappclone.presentation.bottomnavigation

import androidx.annotation.DrawableRes

data class NavigationItem(
    val name: String,
    @DrawableRes val selectedIcon:Int,
    @DrawableRes val unSelectedIcon:Int
)
