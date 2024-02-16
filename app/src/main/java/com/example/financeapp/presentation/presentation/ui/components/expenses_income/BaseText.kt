package com.example.financeapp.presentation.presentation.ui.components.expenses_income

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.sp
import com.example.financeapp.R


@Composable
fun BaseText(text: String, size: Int, color: Color, modifier: Modifier = Modifier,textAlign: TextAlign? = TextAlign.Center){
    Text(
        modifier=modifier,
    text = text,
    fontFamily = FontFamily(Font(R.font.librebaskerville_bold)),
    fontSize = size.sp,
    fontWeight = FontWeight.Bold,
    color = color,
        textAlign = textAlign ?: TextAlign.Center
    )
}