package com.example.financeapp.presentation.domain.use_cases.note.finance

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class ForDateUseCase (private val repository: FinanceRepository) {
    suspend operator fun invoke(selectedDate: LocalDate): Flow<Pair<List<IncomeModel>, List<ExpensesModel>>> {
        return repository.loadExpensesAndIncomeForDate(selectedDate)
    }
}