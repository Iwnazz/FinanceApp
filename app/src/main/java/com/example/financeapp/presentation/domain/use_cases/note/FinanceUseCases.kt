package com.example.financeapp.presentation.domain.use_cases.note

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForDateUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForMonthUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForWeekUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForYearUseCase
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

data class FinanceUseCases(
    val forDateUseCase: ForDateUseCase,
    val forWeekUseCase: ForWeekUseCase,
    val forMonthUseCase: ForMonthUseCase,
    val forYearUseCase: ForYearUseCase
)