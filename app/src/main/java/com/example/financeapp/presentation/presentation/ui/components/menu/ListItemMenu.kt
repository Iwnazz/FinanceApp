package com.example.financeapp.presentation.presentation.ui.components.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financeapp.R
import com.example.financeapp.presentation.domain.model.ButtonItem

@Composable
fun ListItemMenu(item: ButtonItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 32.dp,
                vertical = 32.dp
            )
            .clickable { onItemClick() }
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(16.dp)),
    ) {
        Column(modifier = Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(14.dp))
            Text(
                text = item.name,
                modifier = Modifier,
                fontFamily = FontFamily(Font(R.font.librebaskerville_bold)),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "image",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(18.dp)
                    .size(70.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
        }
    }
}

