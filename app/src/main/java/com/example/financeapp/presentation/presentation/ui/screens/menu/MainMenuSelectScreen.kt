package com.example.financeapp.presentation.presentation.ui.screens.menu


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import com.example.financeapp.R
import com.example.financeapp.presentation.domain.ButtonItemObject
import com.example.financeapp.presentation.domain.model.ButtonItem
import com.example.financeapp.presentation.presentation.ui.components.BackGround
import com.example.financeapp.presentation.presentation.ui.components.animationTime
import com.example.financeapp.presentation.presentation.ui.components.menu.GreetingsForMenu
import com.example.financeapp.presentation.presentation.ui.components.menu.ListItemMenu
import kotlinx.coroutines.delay
import com.example.financeapp.presentation.presentation.ui.screens.Screens

@Composable
fun MainMenuSelectScreen(navController: NavController) {
    val visibility = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(10)
        visibility.value = true
    }

    BackGround()
    val buttonItem = ButtonItemObject.getButtonItem()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visibility.value,
            enter = slideInVertically(animationSpec = tween(durationMillis = animationTime)) + fadeIn()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GreetingsForMenu()
                Spacer(modifier = Modifier.height(16.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    contentPadding = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 20.dp
                    )
                ) {
                    items(buttonItem.size) { index ->
                        ListItemMenu(
                            item = buttonItem[index],
                            onItemClick = {
                                when (index) {
                                    0 -> navController.navigate(Screens.IncomeScreen.route){
                                        popUpTo(Screens.MainMenuSelectScreen.route){
                                            inclusive = true
                                        }
                                    }
                                    1 -> navController.navigate(Screens.ExpensesScreen.route) {
                                        popUpTo(Screens.MainMenuSelectScreen.route) {
                                            inclusive = true
                                        }
                                    }
                                    2 -> navController.navigate(Screens.GeneralScreen.route)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

