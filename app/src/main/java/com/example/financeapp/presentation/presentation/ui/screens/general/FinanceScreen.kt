package com.example.financeapp.presentation.presentation.ui.screens.general

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.financeapp.presentation.core.Period
import com.example.financeapp.presentation.presentation.theme.myGreen
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.BaseText
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.ShowDatePickerDialog
import java.time.LocalDate
import java.time.Month


@Composable
fun RadioGroupSelectedPeriod(
    selectedPeriod: Period,
    selectedDate: LocalDate,
    onPeriodSelected: (Period, LocalDate) -> Unit
) {
    val periods = listOf(Period.DAY, Period.WEEK, Period.MONTH, Period.YEAR)
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (period in periods) {
            RadioButton(
                selected = selectedPeriod == period,
                onClick = {
                    onPeriodSelected(period, selectedDate)
                    Log.d("FinanceScreen", "Selected period: $period")
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = myGreen
                )
            )
        }
    }
}

@Composable
fun FinanceScreen(viewModel: FinanceViewModel = hiltViewModel()) {
    var selectedDate by remember {
        mutableStateOf(
            LocalDate.now()
        )
    }
    var selectedPeriod by remember { mutableStateOf(Period.WEEK) }

    LaunchedEffect(selectedDate, selectedPeriod) {
        viewModel.loadIncomeAndExpensesForPeriod(selectedDate, selectedPeriod)
        Log.d("FinanceScreen", "Selected date: $selectedDate, selected period: $selectedPeriod")
    }
    val incomeAndExpenses by viewModel.incomeAndExpensesForPeriod.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ShowDatePickerDialog(
            selectedDate = selectedDate
        ) { newSelectedDate ->
            selectedDate = newSelectedDate
            viewModel.loadIncomeAndExpensesForPeriod(newSelectedDate, selectedPeriod)
        }

        RadioGroupSelectedPeriod(
            selectedPeriod = selectedPeriod,
            selectedDate = selectedDate,
            onPeriodSelected = { period, date ->
                selectedPeriod = period
                selectedDate = date
            }
        )
        if (incomeAndExpenses.first.isNotEmpty() || incomeAndExpenses.second.isNotEmpty()) {
            val totalIncome = incomeAndExpenses.first.sumByDouble { it.sumOfMoney.toDouble() }
            val totalExpenses = incomeAndExpenses.second.sumByDouble { it.sumOfMoney.toDouble() }

            val total = totalIncome - totalExpenses
            Card(
                modifier = Modifier
                    .padding(
                        horizontal = 32.dp,
                        vertical = 32.dp
                    )
                    .fillMaxWidth(),
                shape = RoundedCornerShape(CornerSize(16.dp)),
                colors = CardDefaults.cardColors(myGreen),
                elevation = CardDefaults.cardElevation(12.dp)
            ) {
                BaseText(text = "Общий доход: $totalIncome", size = 24, color = Color.Black)
                BaseText(text = "Общий расход: $totalExpenses", size = 24, color = Color.Black)
                BaseText(text = "Итого: $total", size = 24, color = Color.Black)
            }
        } else {
            Text(
                text = "Нет данных для выбранной даты",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}