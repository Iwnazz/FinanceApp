package com.example.financeapp.presentation.data.repo

import com.example.financeapp.presentation.data.local.ExpensesDao
import com.example.financeapp.presentation.data.local.IncomeDao
import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.ExpensesRepository
import com.example.financeapp.presentation.domain.repository.IncomeRepository

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class ExpensesRepositoryImpl(
    private val dao: ExpensesDao
) : ExpensesRepository {

    override fun getNotes(): Flow<List<ExpensesModel>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): ExpensesModel? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note:  ExpensesModel) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note:  ExpensesModel) {
        dao.deleteNote(note)
    }

    override suspend fun updateNote(note:  ExpensesModel) {
        dao.updateNote(note)
    }

    override suspend fun getExpensesForDate(selectedDate: LocalDate): Flow<List<ExpensesModel>> {
        return dao.getExpensesForDate(selectedDate)
    }

    override suspend fun getExpensesForWeek(startDate: LocalDate, endDate: LocalDate): Flow<List<ExpensesModel>> {
        val startDateString = startDate.toString()
        val endDateString = endDate.toString()
        return dao.getExpensesForWeek(startDateString, endDateString)
    }

    override suspend fun getExpensesForMonth(year: Int, month: Int): Flow<List<ExpensesModel>> {
        val yearMonth = String.format("%d-%02d", year, month)
        return dao.getExpensesForMonth(yearMonth)
    }

    override suspend fun getExpensesForYear(year: Int): Flow<List<ExpensesModel>> {
        val yearString = year.toString()
        return dao.getExpensesForYear(yearString)
    }
}