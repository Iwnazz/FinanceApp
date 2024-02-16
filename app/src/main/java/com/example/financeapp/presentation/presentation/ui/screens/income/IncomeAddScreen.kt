package com.example.financeapp.presentation.presentation.ui.screens.income

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.presentation.ui.components.BackGround
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.MainPattern
import com.example.financeapp.presentation.presentation.ui.screens.Screens
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeAddScreen(
    navHostController: NavHostController,
    viewModel: IncomeViewModel,
    onIncomeAdded: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var sumOfMoney by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    BackGround()
    MainPattern(
        onAction = onIncomeAdded,
        titleValue = title,
        whatAdd = "income",
        sumOfMoneyValue = sumOfMoney,
        selectedDate = selectedDate,
        onTitleChange = { title = it },
        onSumOfMoneyChange = { sumOfMoney = it },
        onDateChange = { selectedDate = it },
        actionButtonLabel = "Add Income",
        onActionButtonClick = {
            val newNote = IncomeModel(
                title = title,
                sumOfMoney = sumOfMoney,
                timestamp = System.currentTimeMillis(),
                date = selectedDate
            )
            viewModel.addNote(newNote)
        },
        onBackClicked = {
            navHostController.navigate(Screens.IncomeScreen.route) {
                popUpTo(Screens.IncomeAddScreen.route) {
                    inclusive = true
                }
            }
        }
    )
}