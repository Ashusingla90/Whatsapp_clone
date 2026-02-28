package com.example.whatsappclone.presentation.callscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
fun CallItemDesign(callItemData: CallItemData) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(callItemData.image), contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(text = callItemData.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_call_missed_24), null,
                    modifier = Modifier.size(16.dp),
                    tint = if (callItemData.isMissed) Color.Red else colorResource(R.color.light_green)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = callItemData.time,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }

        }

        Box() {


            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.telephone), null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}