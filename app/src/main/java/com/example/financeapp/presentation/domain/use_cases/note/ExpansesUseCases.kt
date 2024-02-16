package com.example.financeapp.presentation.domain.use_cases.note

import com.example.financeapp.presentation.domain.use_cases.note.expenses.AddExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.DeleteExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.GetExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.GetsExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.UpdateExpensesUseCase

data class ExpansesUseCases(
    val addExpensesUseCase: AddExpensesUseCase,
    val deleteExpensesUseCase: DeleteExpensesUseCase,
    val getExpensesUseCase: GetExpensesUseCase,
    val getsExpensesUseCase: GetsExpensesUseCase,
    val updateExpensesUseCase: UpdateExpensesUseCase
)