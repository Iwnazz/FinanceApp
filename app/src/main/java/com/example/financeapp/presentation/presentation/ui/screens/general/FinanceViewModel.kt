@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.example.financeapp.presentation.presentation.ui.screens.general

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.presentation.core.Period
import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.use_cases.note.FinanceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class FinanceViewModel @Inject constructor(private val financeUseCase: FinanceUseCases): ViewModel() {
    private val _incomeAndExpensesForPeriod = MutableStateFlow<Pair<List<IncomeModel>, List<ExpensesModel>>>(emptyList<IncomeModel>() to emptyList<ExpensesModel>())
    val incomeAndExpensesForPeriod: StateFlow<Pair<List<IncomeModel>, List<ExpensesModel>>> = _incomeAndExpensesForPeriod

    fun loadIncomeAndExpensesForPeriod(selectedDate: LocalDate, period: Period) {
        viewModelScope.launch {
            when (period) {
                Period.DAY -> {
                    Log.d(TAG, "Loading data for day: $selectedDate")
                    financeUseCase.forDateUseCase(selectedDate)
                }
                Period.WEEK -> {
                    val startDate = selectedDate.minusDays(selectedDate.dayOfWeek.value.toLong() - 1)
                    val endDate = startDate.plusDays(6)
                    Log.d(TAG, "Loading data for week: $startDate - $endDate")
                    financeUseCase.forWeekUseCase(startDate, endDate)
                }
                Period.MONTH -> {
                    Log.d(TAG, "Loading data for month: ${selectedDate.year}-${selectedDate.monthValue}")
                    financeUseCase.forMonthUseCase(selectedDate.year, selectedDate.monthValue)
                }
                Period.YEAR -> {
                    Log.d(TAG, "Loading data for year: ${selectedDate.year}")
                    financeUseCase.forYearUseCase(selectedDate.year)
                }
            }.collect {
                Log.d(TAG, "Data loaded: $it")
                _incomeAndExpensesForPeriod.value = it
            }
        }
    }

    companion object {
        private const val TAG = "FinanceViewModel"
    }
}