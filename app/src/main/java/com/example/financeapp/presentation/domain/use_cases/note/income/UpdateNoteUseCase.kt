package com.example.financeapp.presentation.domain.use_cases.note.income

import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.IncomeRepository

class UpdateNoteUseCase(private val repository: IncomeRepository) {
    suspend operator fun invoke(note: IncomeModel) {
        repository.updateNote(note)
    }
}