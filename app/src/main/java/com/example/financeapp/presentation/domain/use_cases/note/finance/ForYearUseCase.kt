package com.example.financeapp.presentation.domain.use_cases.note.finance

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow

class ForYearUseCase(private val financeRepository: FinanceRepository) {
    suspend operator fun invoke(year: Int): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        return financeRepository.loadExpensesAndIncomeForYear(year)
    }
}