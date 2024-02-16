package com.example.financeapp.presentation.presentation.ui.components.expenses_income

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.financeapp.presentation.presentation.theme.myGreen

@Composable
fun TopOfNote(onBackClicked: () -> Unit, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onBackClicked() },
            modifier = Modifier.size(48.dp),
            content = {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            },
            colors = IconButtonDefaults.iconButtonColors(Color.White.copy(alpha = 0.8f)),
        )

        BaseText(modifier = Modifier.weight(1f),
            text = text, size = 26, color = myGreen)
}
    Spacer(modifier = Modifier.height(4.dp))
    Divider(color = myGreen, thickness = 4.dp)
}