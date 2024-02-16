package com.example.financeapp.presentation.presentation.ui.screens.expenses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.financeapp.presentation.presentation.ui.components.BackGround
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.BaseFloatingActionButton
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.EditNote
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.MainPattern
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.NoteCard
import com.example.financeapp.presentation.presentation.ui.components.expenses_income.TopOfNote
import com.example.financeapp.presentation.presentation.ui.screens.Screens

@Composable
fun ExpensesScreen(
    navigateToExpensesAddScreen: () -> Unit,
    onBackClicked:() -> Unit,
    viewModel:ExpensesScreenViewModel,
    modifier:Modifier = Modifier
   ){

    val notesState by viewModel.notes.collectAsState(initial = emptyList())
    BackGround()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopOfNote(onBackClicked = { onBackClicked() }, text = "Expenses")
            LazyColumn {
                items(notesState) { note ->
                    var isEditing by remember { mutableStateOf(false) }
                    var editedTitle by remember { mutableStateOf(note.title) }
                    var editedSumOfMoney by remember { mutableStateOf(note.sumOfMoney) }
                    var editedDate by remember { mutableStateOf(note.date) }

                    if (isEditing) {
                        EditNote(
                            note = note,
                            editedTitle = editedTitle,
                            editedSumOfMoney = editedSumOfMoney,
                            editedDate = editedDate,
                            onTitleChange = { editedTitle = it },
                            onSumOfMoneyChange = { editedSumOfMoney = it },
                            onDateChange = { editedDate = it },
                            onSave = {
                                viewModel.updateNote(
                                    note.copy(
                                        title = editedTitle,
                                        sumOfMoney = editedSumOfMoney,
                                        date = editedDate,
                                    )
                                )
                                isEditing = false
                            }
                        )
                    } else {
                        NoteCard(note = note, {
                            viewModel.deleteNote(note)
                        }) {
                            isEditing = true
                        }
                    }
                }
            }
        }
        BaseFloatingActionButton(
            onClick = navigateToExpensesAddScreen,
            modifier = modifier.padding(16.dp).align(Alignment.BottomEnd),
            iconTint = Color.Black
        )
    }
}