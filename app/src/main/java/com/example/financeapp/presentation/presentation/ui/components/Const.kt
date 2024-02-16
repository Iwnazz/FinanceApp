package com.example.financeapp.presentation.presentation.ui.components

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.financeapp.R
import com.example.financeapp.presentation.presentation.theme.GeeksBlue
import com.example.financeapp.presentation.presentation.theme.myGreen
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.BaseText
import java.time.LocalDateTime


@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = myGreen),
        shape = RoundedCornerShape(10.dp)
    ) {
        BaseText(text = text, size = 16, color = Color.White)
    }
}

@Composable
fun Toast(message: String) {
    android.widget.Toast.makeText(LocalContext.current, message, android.widget.Toast.LENGTH_SHORT).show()
}

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoField(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 4.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontWeight = FontWeight.Bold),
            label = {
                Text(
                    text = label,
                    fontWeight = FontWeight.Bold
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    fontWeight = FontWeight.Bold
                )
            },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = myGreen,
                unfocusedIndicatorColor = Color.Black,
                focusedIndicatorColor = myGreen,
                focusedLabelColor = myGreen,
                unfocusedLabelColor = GeeksBlue,
                focusedLeadingIconColor = myGreen
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}

fun getGreeting(): String {
    return when (LocalDateTime.now().toLocalTime().hour) {
        in 6..11 -> "Good morning"
        in 12..17 -> "Guten Tag"
        in 18..22 -> "Good evening"
        else -> "Can't sleep?"
    }
}

@Composable
fun BackGround(){
    Image(
        painter = painterResource(id = R.drawable.wallpaper),
        contentDescription = "wallpaper",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)
}


const val animationTime = 2000


