package com.example.financeapp.presentation.presentation.ui.components.expenses_income

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import java.time.Instant
import java.time.ZoneId

@Composable
fun <T> NoteCard(
    note: T,
    onDeleteNote: (T) -> Unit,
    onCLick: () -> Unit
) {
    val timestamp = when (note) {
        is IncomeModel -> "Created: ${note.timestamp?.let {
            val dateTime = Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDateTime()
            "${dateTime.year}-${dateTime.month}-${dateTime.dayOfMonth} ${dateTime.hour}:${dateTime.minute}"
        }}"
        is ExpensesModel -> "Created: ${note.timestamp?.let {
            val dateTime = Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDateTime()
            "${dateTime.year}-${dateTime.month}-${dateTime.dayOfMonth} ${dateTime.hour}:${dateTime.minute}"
        }}"
        else -> ""
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onCLick() }
            ) {
                when (note) {
                    is IncomeModel -> {
                        BaseText(text = note.title, size = 20, Color.Black)
                        BaseText(text = note.sumOfMoney, size = 20, color = Color.Black)
                        BaseText(text = note.date.toString(), size = 18, Color.Black)
                        BaseText(text = timestamp, size = 16, Color.Black)
                    }
                    is ExpensesModel -> {
                        BaseText(text = note.title, size = 20, Color.Black)
                        BaseText(text = note.sumOfMoney, size = 20, color = Color.Black)
                        BaseText(text = note.date.toString(), size = 18, Color.Black)
                        BaseText(text = timestamp, size = 16, Color.Black)
                    }
                    else -> {

                    }
                }
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Edit",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDeleteNote.invoke(note) }
            )
        }
    }
}