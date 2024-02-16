package com.example.financeapp.presentation.presentation.ui.components.menu

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.financeapp.R
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.BaseText
import com.example.financeapp.presentation.presentation.ui.components.getGreeting

@Composable
fun GreetingsForMenu(){
    val greeting = getGreeting()
    BaseText(text = greeting, size = 26, color = Color.White)
}