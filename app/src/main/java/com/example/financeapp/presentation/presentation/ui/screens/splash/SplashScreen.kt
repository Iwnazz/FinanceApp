package com.example.squareapp.present.theme.presenter.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financeapp.R
import com.example.financeapp.presentation.presentation.theme.myGreen
import com.example.financeapp.presentation.presentation.ui.components.BackGround
import com.example.financeapp.presentation.presentation.ui.screens.Screens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(durationMillis = 1500, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay(1000)
        navController.navigate(Screens.MainMenuSelectScreen.route){
            popUpTo(Screens.SplashScreen.route){
                inclusive = true
            }
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxSize()) {
        BackGround()
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, ) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Splash Screen Logo", modifier = Modifier
                    .scale(scale.value)
                    .size(410.dp))
            Text(text = "Square App",
                fontWeight = FontWeight.Bold,
                fontSize = 76.sp,
                color = myGreen,
                modifier = Modifier.scale(scale.value),
                textAlign = TextAlign.Center)
        }
    }
}
