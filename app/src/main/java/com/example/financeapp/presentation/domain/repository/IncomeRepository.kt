package com.example.financeapp.presentation.domain.repository

import com.example.financeapp.presentation.domain.model.IncomeModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface IncomeRepository {

    fun getNotes(): Flow<List<IncomeModel>>

    suspend fun getNoteById(id: Int): IncomeModel?

    suspend fun insertNote(note: IncomeModel)

    suspend fun deleteNote(note: IncomeModel)

    suspend fun updateNote(note: IncomeModel)

    suspend fun getIncomeForDate(selectedDate: LocalDate): Flow<List<IncomeModel>>
    
    suspend fun getIncomeForWeek(startDate: LocalDate, endDate: LocalDate): Flow<List<IncomeModel>>

    suspend fun getIncomeForMonth(year: Int, month: Int): Flow<List<IncomeModel>>

    suspend fun getIncomeForYear(year: Int): Flow<List<IncomeModel>>
}