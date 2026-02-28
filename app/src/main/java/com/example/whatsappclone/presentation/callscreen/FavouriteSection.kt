package com.example.whatsappclone.presentation.callscreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
fun FavouriteSection() {
    val sampleFav = listOf(
        FavContactData(image = R.drawable.ajay, name = "Ajay"),
        FavContactData(image = R.drawable.karan, name = "Karan"),
        FavContactData(image = R.drawable.amit, name = "Amit"),
        FavContactData(image = R.drawable.ashish, name = "Ashish "),
        FavContactData(image = R.drawable.kartik, name = "Kartik"),
        FavContactData(image = R.drawable.gautam, name = "Gautam"),
        FavContactData(image = R.drawable.pardeep, name = "Pardeep")

    )

    Column(modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)) {
        Text(
            text = "Favourites", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {

            sampleFav.forEach {
                FavouriteItems(it)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FavSectionPrev() {
    FavouriteSection()
}