package com.example.financeapp.presentation.presentation.ui.screens.income

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.presentation.domain.model.IncomeModel
import com.example.financeapp.presentation.domain.use_cases.note.IncomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncomeViewModel @Inject constructor(
    private val noteUseCases: IncomeUseCases
) : ViewModel() {
    private val _notes = MutableStateFlow<List<IncomeModel>>(emptyList())
    val notes: StateFlow<List<IncomeModel>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            noteUseCases.getNotesUseCase().collect { notesList ->
                _notes.value = notesList
            }
        }
    }

    fun addNote(note: IncomeModel) {
        viewModelScope.launch {
            noteUseCases.addNoteUseCase(note)
        }
    }
    fun deleteNote(note:IncomeModel){
        viewModelScope.launch {
          noteUseCases.deleteUseCase(note)
        }
    }
    fun updateNote(note: IncomeModel) {
        viewModelScope.launch {
            noteUseCases.updateNoteUseCase(note)
        }
    }
}