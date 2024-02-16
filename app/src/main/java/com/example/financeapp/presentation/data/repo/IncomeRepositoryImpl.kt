package com.example.financeapp.presentation.data.repo

import com.example.financeapp.presentation.data.local.IncomeDao
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.IncomeRepository

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class IncomeRepositoryImpl(
    private val dao: IncomeDao
) : IncomeRepository {

    override fun getNotes(): Flow<List<IncomeModel>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): IncomeModel? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: IncomeModel) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: IncomeModel) {
        dao.deleteNote(note)
    }

    override suspend fun updateNote(note: IncomeModel) {
        dao.updateNote(note)
    }

    override suspend fun getIncomeForDate(selectedDate: LocalDate): Flow<List<IncomeModel>> {
        return dao.getIncomeForDate(selectedDate)
    }

    override suspend fun getIncomeForWeek(startDate: LocalDate, endDate: LocalDate): Flow<List<IncomeModel>> {
        val startDateString = startDate.toString()
        val endDateString = endDate.toString()
        return dao.getIncomeForWeek(startDateString, endDateString)
    }

    override suspend fun getIncomeForMonth(year: Int, month: Int): Flow<List<IncomeModel>> {
        val yearMonth = String.format("%d-%02d", year, month)
        return dao.getIncomeForMonth(yearMonth)
    }

    override suspend fun getIncomeForYear(year: Int): Flow<List<IncomeModel>> {
        val yearString = year.toString()
        return dao.getIncomeForYear(yearString)
    }
}