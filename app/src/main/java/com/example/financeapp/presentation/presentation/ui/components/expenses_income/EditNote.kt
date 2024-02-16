package com.example.financeapp.presentation.presentation.ui.components.expenses_income

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.presentation.ui.components.BaseButton
import com.example.financeapp.presentation.presentation.ui.components.DemoField
import java.time.LocalDate

@Composable
fun <T> EditNote(
    note: T,
    editedTitle: String,
    editedSumOfMoney: String,
    editedDate: LocalDate?,
    onTitleChange: (String) -> Unit,
    onSumOfMoneyChange: (String) -> Unit,
    onDateChange: (LocalDate) -> Unit,
    onSave: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Click outside to save */ }
                .padding(16.dp)
        ) {
            DemoField(
                value = editedTitle,
                label = "name",
                placeholder = "name",
                onValueChange = onTitleChange
            )
            DemoField(
                value = editedSumOfMoney,
                label = "name",
                placeholder = "name",
                onValueChange = onSumOfMoneyChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShowDatePickerDialog(
                    selectedDate = editedDate,
                    onDateChange = onDateChange
                )
                Spacer(modifier = Modifier.width(8.dp))
                BaseButton(
                    text = "Save",
                    onClick = onSave,
                    modifier = Modifier.size(width = 90.dp, height = 40.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}