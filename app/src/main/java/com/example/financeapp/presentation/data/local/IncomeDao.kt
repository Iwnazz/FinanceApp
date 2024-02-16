package com.example.financeapp.presentation.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.financeapp.presentation.domain.model.IncomeModel


import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface IncomeDao {

    @Query("SELECT * FROM IncomeModel")
    fun getNotes(): Flow<List<IncomeModel>>

    @Query("SELECT * FROM incomemodel WHERE id = :id")
    suspend fun getNoteById(id: Int): IncomeModel?

    @Update
    suspend fun updateNote(note: IncomeModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: IncomeModel)

    @Delete
    suspend fun deleteNote(note: IncomeModel)

    @Query("SELECT * FROM IncomeModel WHERE date = :selectedDate")
    fun getIncomeForDate(selectedDate: LocalDate): Flow<List<IncomeModel>>

    @Query("SELECT * FROM IncomeModel WHERE strftime('%Y-%m-%d', date) BETWEEN :startDate AND :endDate")
    fun getIncomeForWeek(startDate: String, endDate: String): Flow<List<IncomeModel>>

    @Query("SELECT * FROM IncomeModel WHERE strftime('%Y-%m', date) = :yearMonth")
    fun getIncomeForMonth(yearMonth: String): Flow<List<IncomeModel>>

    @Query("SELECT * FROM IncomeModel WHERE strftime('%Y', date) = :year")
    fun getIncomeForYear(year: String): Flow<List<IncomeModel>>
}