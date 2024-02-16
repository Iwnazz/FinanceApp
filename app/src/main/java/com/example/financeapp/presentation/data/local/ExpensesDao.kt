package com.example.financeapp.presentation.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.financeapp.presentation.domain.model.ExpensesModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface ExpensesDao {
    @Query("SELECT * FROM expensesModel")
    fun getNotes(): Flow<List<ExpensesModel>>

    @Query("SELECT * FROM expensesModel WHERE id = :id")
    suspend fun getNoteById(id: Int): ExpensesModel?

    @Update
    suspend fun updateNote(note: ExpensesModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: ExpensesModel)

    @Delete
    suspend fun deleteNote(note: ExpensesModel)

    @Query("SELECT * FROM ExpensesModel WHERE date = :selectedDate")
    fun getExpensesForDate(selectedDate: LocalDate): Flow<List<ExpensesModel>>

    @Query("SELECT * FROM ExpensesModel WHERE strftime('%Y-%m-%d', date) BETWEEN :startDate AND :endDate")
    fun getExpensesForWeek(startDate: String, endDate: String): Flow<List<ExpensesModel>>

    @Query("SELECT * FROM ExpensesModel WHERE strftime('%Y-%m', date) = :yearMonth")
    fun getExpensesForMonth(yearMonth: String): Flow<List<ExpensesModel>>

    @Query("SELECT * FROM ExpensesModel WHERE strftime('%Y', date) = :year")
    fun getExpensesForYear(year: String): Flow<List<ExpensesModel>>
}