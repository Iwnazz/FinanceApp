package com.example.financeapp.presentation.domain.use_cases.note

import com.example.financeapp.presentation.domain.use_cases.note.income.AddNoteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.DeleteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.GetNoteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.GetNotesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.UpdateNoteUseCase

class IncomeUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteUseCase: DeleteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val getNoteUseCase: GetNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase
    )