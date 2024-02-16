package com.example.financeapp.presentation.presentation.ui.screens.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.presentation.domain.model.ExpensesModel
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.use_cases.note.ExpansesUseCases
import com.example.financeapp.presentation.domain.use_cases.note.IncomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpensesScreenViewModel @Inject constructor(
    private val noteUseCases: ExpansesUseCases
): ViewModel() {
    private val _notes = MutableStateFlow<List<ExpensesModel>>(emptyList())
    val notes: StateFlow<List<ExpensesModel>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            noteUseCases.getExpensesUseCase().collect { notesList ->
                _notes.value = notesList
            }
        }
    }

    fun addNote(note:ExpensesModel) {
        viewModelScope.launch {
            noteUseCases.addExpensesUseCase(note)
        }
    }
    fun deleteNote(note: ExpensesModel){
        viewModelScope.launch {
            noteUseCases.deleteExpensesUseCase(note)
        }
    }
    fun updateNote(note: ExpensesModel) {
        viewModelScope.launch {
            noteUseCases.updateExpensesUseCase(note)
        }
    }
}