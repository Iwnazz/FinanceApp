package com.example.financeapp.presentation.presentation.ui.components.expenses_income

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.financeapp.presentation.core.Period
import com.example.financeapp.presentation.presentation.theme.myGreen
import com.example.financeapp.presentation.presentation.ui.components.BaseButton
import com.example.financeapp.presentation.presentation.ui.components.DemoField
import java.time.LocalDate

@Composable
fun MainPattern(
    onAction: () -> Unit,
    titleValue: String = "",
    whatAdd: String,
    sumOfMoneyValue: String = "",
    selectedDate: LocalDate,
    onTitleChange: (String) -> Unit,
    onSumOfMoneyChange: (String) -> Unit,
    onDateChange: (LocalDate) -> Unit,
    actionButtonLabel: String,
    onActionButtonClick: () -> Unit,
    onBackClicked: () -> Unit
) {
    var isFieldsFilled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(
            onClick = { onBackClicked() },
            modifier = Modifier.size(48.dp),
            content = {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            },
            colors = IconButtonDefaults.iconButtonColors(Color.White.copy(alpha = 0.8f)),
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .widthIn(max = 400.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.8f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 24.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    DemoField(
                        value = titleValue,
                        label = "name",
                        placeholder = "name",
                        onValueChange = { newText ->
                            onTitleChange(newText)
                            isFieldsFilled = newText.isNotEmpty() && sumOfMoneyValue.isNotEmpty()
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Info, contentDescription = "name")
                        }
                    )
                    DemoField(
                        value = sumOfMoneyValue,
                        label = whatAdd,
                        placeholder = whatAdd,
                        onValueChange = { newText ->
                            onSumOfMoneyChange(newText)
                            isFieldsFilled = newText.isNotEmpty() && titleValue.isNotEmpty()
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Info, contentDescription = "add")
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        ShowDatePickerDialog(
                            selectedDate = selectedDate,
                            onDateChange = onDateChange
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        BaseButton(
                            text = "Add",
                            onClick = {
                                if (isFieldsFilled) {
                                    onActionButtonClick()
                                    onAction()
                                }
                            },
                            modifier = Modifier.size(width = 90.dp, height = 40.dp),
                            enabled = isFieldsFilled
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowDatePickerDialog(
    selectedDate: LocalDate?,
    onDateChange: (LocalDate) -> Unit
) {
    val context = LocalContext.current

    Button(
        onClick = {
            showDatePickerDialog(context, selectedDate) { newDate ->
                onDateChange(newDate)
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = myGreen),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.size(width = 90.dp, height = 40.dp)
    ) {
        Icon(Icons.Filled.DateRange, contentDescription = "Select Date", modifier = Modifier.size(34.dp))
    }
}

fun showDatePickerDialog(
    context: Context,
    selectedDate: LocalDate?,
    onDateChange: (LocalDate) -> Unit
) {
    val currentDate = selectedDate ?: LocalDate.now()

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val newDate = LocalDate.of(year, month + 1, dayOfMonth)
            onDateChange(newDate)
        },
        currentDate.year,
        currentDate.monthValue - 1,
        currentDate.dayOfMonth
    )

    datePickerDialog.show()
}