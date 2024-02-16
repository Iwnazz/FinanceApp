package com.example.financeapp.presentation.data.repo

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.ExpensesRepository
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import com.example.financeapp.presentation.domain.repository.IncomeRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.time.LocalDate

class FinanceRepositoryImpl(
    private val incomeRepository: IncomeRepository,
    private val expensesRepository: ExpensesRepository
) : FinanceRepository {

    override suspend fun loadExpensesAndIncomeForDate(selectedDate: LocalDate): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        val incomeForDate: Flow<List<IncomeModel>> = incomeRepository.getIncomeForDate(selectedDate)
        val expensesForDate: Flow<List<ExpensesModel>> =
            expensesRepository.getExpensesForDate(selectedDate)
        return combine(incomeForDate, expensesForDate) { income, expenses ->
            income to expenses
        }
    }

    override suspend fun loadExpensesAndIncomeForWeek(
        startDate: LocalDate,
        endDate: LocalDate
    ): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        val incomeForWeek: Flow<List<IncomeModel>> =
            incomeRepository.getIncomeForWeek(startDate, endDate)
        val expensesForWeek: Flow<List<ExpensesModel>> =
            expensesRepository.getExpensesForWeek(startDate, endDate)
        return combine(incomeForWeek, expensesForWeek) { income, expenses ->
            income to expenses
        }
    }

    override suspend fun loadExpensesAndIncomeForMonth(
        year: Int,
        month: Int
    ): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        val incomeForMonth: Flow<List<IncomeModel>> =
            incomeRepository.getIncomeForMonth(year, month)
        val expensesForMonth: Flow<List<ExpensesModel>> =
            expensesRepository.getExpensesForMonth(year, month)
        return combine(incomeForMonth, expensesForMonth) { income, expenses ->
            income to expenses
        }
    }

    override suspend fun loadExpensesAndIncomeForYear(year: Int): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        val incomeForYear: Flow<List<IncomeModel>> = incomeRepository.getIncomeForYear(year)
        val expensesForYear: Flow<List<ExpensesModel>> = expensesRepository.getExpensesForYear(year)
        return combine(incomeForYear, expensesForYear) { income, expenses ->
            income to expenses
        }
    }
}