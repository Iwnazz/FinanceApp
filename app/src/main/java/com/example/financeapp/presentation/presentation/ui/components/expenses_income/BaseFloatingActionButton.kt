package com.example.financeapp.presentation.presentation.ui.components.expenses_income


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.financeapp.presentation.presentation.theme.myGreen

@Composable
fun BaseFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier,
    backgroundColor: Color = myGreen,
    contentDescription: String? = null,
    icon: ImageVector? = null,
    iconTint: Color = Color.Black
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier ,
        containerColor = backgroundColor
    ) {
        Icon(
            imageVector = icon ?: Icons.Default.Add,
            contentDescription = contentDescription ?: "Add Note",
            tint = iconTint
        )
    }
}