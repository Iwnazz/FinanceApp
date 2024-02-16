package com.example.financeapp.presentation.domain.use_cases.note.income

import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.repository.IncomeRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(private val repository: IncomeRepository){
    suspend operator fun invoke(): Flow<List<IncomeModel>> {
        return repository.getNotes()
    }
}