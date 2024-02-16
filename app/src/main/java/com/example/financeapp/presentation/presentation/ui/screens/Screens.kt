package com.example.financeapp.presentation.presentation.ui.screens

sealed class Screens(val route:String) {
    object SplashScreen : Screens("splash_screen")
    object GeneralScreen : Screens("general_screen")
    object MainMenuSelectScreen : Screens("mms_screen")
    object IncomeScreen : Screens("income_screen")
    object IncomeAddScreen : Screens("income_add_screen")
    object ExpensesScreen : Screens("expenses_screen")
    object ExpensesAddScreen : Screens("expenses_add_screen")
}
