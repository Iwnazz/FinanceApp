package com.example.financeapp.presentation.domain.use_cases.note.expenses

import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.ExpensesRepository
import com.example.financeapp.presentation.domain.repository.IncomeRepository

class AddExpensesUseCase(private val repository: ExpensesRepository) {
        suspend operator fun invoke(note: ExpensesModel) {
            repository.insertNote(note)
        }
}