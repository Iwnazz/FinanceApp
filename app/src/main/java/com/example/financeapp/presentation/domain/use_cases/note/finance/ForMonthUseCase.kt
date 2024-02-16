package com.example.financeapp.presentation.domain.use_cases.note.finance

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow

class ForMonthUseCase(private val financeRepository: FinanceRepository) {
    suspend operator fun invoke(year: Int, month: Int): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
       return financeRepository.loadExpensesAndIncomeForMonth(year, month)
    }
}