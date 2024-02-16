package com.example.financeapp.presentation.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class IncomeModel(
    val title: String = "null",
    val sumOfMoney: String = "null",
    var timestamp: Long? = null,
    val date: LocalDate? = null,
    @PrimaryKey val id: Int? = null
)

