package com.example.financeapp.presentation.domain.repository

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.YearMonth

interface FinanceRepository {
    suspend fun loadExpensesAndIncomeForDate(selectedDate: LocalDate): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>>
    suspend fun loadExpensesAndIncomeForWeek(startDate: LocalDate, endDate: LocalDate): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>>
    suspend fun loadExpensesAndIncomeForMonth(year: Int, month: Int): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>>
    suspend fun loadExpensesAndIncomeForYear(year: Int): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>>
}