package com.example.financeapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.financeapp.presentation.data.local.NoteDatabase
import com.example.financeapp.presentation.data.repo.ExpensesRepositoryImpl
import com.example.financeapp.presentation.data.repo.FinanceRepositoryImpl
import com.example.financeapp.presentation.data.repo.IncomeRepositoryImpl
import com.example.financeapp.presentation.domain.repository.ExpensesRepository
import com.example.financeapp.presentation.domain.repository.FinanceRepository
import com.example.financeapp.presentation.domain.repository.IncomeRepository
import com.example.financeapp.presentation.domain.use_cases.note.ExpansesUseCases
import com.example.financeapp.presentation.domain.use_cases.note.FinanceUseCases
import com.example.financeapp.presentation.domain.use_cases.note.income.AddNoteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.IncomeUseCases
import com.example.financeapp.presentation.domain.use_cases.note.expenses.AddExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.DeleteExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.GetExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.GetsExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.expenses.UpdateExpensesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForDateUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForMonthUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForWeekUseCase
import com.example.financeapp.presentation.domain.use_cases.note.finance.ForYearUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.DeleteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.GetNoteUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.GetNotesUseCase
import com.example.financeapp.presentation.domain.use_cases.note.income.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideIncomeRepository(db: NoteDatabase): IncomeRepository {
        return IncomeRepositoryImpl(db.incomeDao())
    }

    @Provides
    @Singleton
    fun provideExpensesRepository(db: NoteDatabase): ExpensesRepository {
        return ExpensesRepositoryImpl(db.expenseDao())
    }

    @Provides
    @Singleton
    fun provideIncomeUseCases(noteRepository: IncomeRepository): IncomeUseCases {
        return IncomeUseCases(
            GetNotesUseCase(noteRepository),
            DeleteUseCase(noteRepository),
            AddNoteUseCase(noteRepository),
            GetNoteUseCase(noteRepository),
            UpdateNoteUseCase(noteRepository)
        )
    }

    @Provides
    @Singleton
    fun provideExpensesUseCases(expensesRepo: ExpensesRepository): ExpansesUseCases {
        return ExpansesUseCases(
            AddExpensesUseCase(expensesRepo),
            DeleteExpensesUseCase(expensesRepo),
            GetExpensesUseCase(expensesRepo),
            GetsExpensesUseCase(expensesRepo),
            UpdateExpensesUseCase(expensesRepo)
        )
    }
    @Provides
    @Singleton
    fun provideFinanceUseCase(repository: FinanceRepository): FinanceUseCases{
        return FinanceUseCases(
            ForDateUseCase(repository),
            ForWeekUseCase(repository),
            ForMonthUseCase(repository),
            ForYearUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideFinanceRepository(incomeRepository: IncomeRepository, expensesRepository: ExpensesRepository): FinanceRepository{
        return FinanceRepositoryImpl(incomeRepository, expensesRepository)
    }
}