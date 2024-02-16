package com.example.financeapp.presentation.domain.repository

import com.example.financeapp.presentation.domain.model.ExpensesModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ExpensesRepository {
    fun getNotes(): Flow<List<ExpensesModel>>

    suspend fun getNoteById(id: Int): ExpensesModel?

    suspend fun insertNote(note: ExpensesModel)

    suspend fun deleteNote(note: ExpensesModel)

    suspend fun updateNote(note: ExpensesModel)

    suspend fun getExpensesForDate(selectedDate: LocalDate): Flow<List<ExpensesModel>>

    suspend fun getExpensesForWeek(startDate: LocalDate, endDate: LocalDate): Flow<List<ExpensesModel>>

    suspend fun getExpensesForMonth(year: Int, month: Int): Flow<List<ExpensesModel>>

    suspend fun getExpensesForYear(year: Int): Flow<List<ExpensesModel>>
}