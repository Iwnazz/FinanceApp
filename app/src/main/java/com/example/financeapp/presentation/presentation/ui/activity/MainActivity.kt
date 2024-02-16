package com.example.financeapp.presentation.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financeapp.presentation.presentation.ui.screens.Screens
import com.example.financeapp.presentation.presentation.ui.screens.expenses.ExpensesAddScreen
import com.example.financeapp.presentation.presentation.ui.screens.expenses.ExpensesScreen
import com.example.financeapp.presentation.presentation.ui.screens.expenses.ExpensesScreenViewModel
import com.example.financeapp.presentation.presentation.ui.screens.general.FinanceScreen
import com.example.financeapp.presentation.presentation.ui.screens.general.FinanceViewModel
import com.example.financeapp.presentation.presentation.ui.screens.income.IncomeAddScreen
import com.example.financeapp.presentation.presentation.ui.screens.income.IncomeScreen
import com.example.financeapp.presentation.presentation.ui.screens.income.IncomeViewModel
import com.example.financeapp.presentation.presentation.ui.screens.menu.MainMenuSelectScreen
import com.example.squareapp.present.theme.presenter.ui.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: IncomeViewModel = hiltViewModel()
            val financeViewModel : FinanceViewModel = hiltViewModel()
            val expensesScreenViewModel: ExpensesScreenViewModel = hiltViewModel()

            NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
                composable(route = Screens.MainMenuSelectScreen.route){
                    MainMenuSelectScreen(navController = navController)
                }
                composable(route = Screens.SplashScreen.route) {
                    SplashScreen(navController = navController)
                }
                composable(route = Screens.GeneralScreen.route) {
                    FinanceScreen(financeViewModel)
                }
                composable(route = Screens.IncomeScreen.route) {
                    IncomeScreen(
                        navigateToAddScreen = { navController.navigate(Screens.IncomeAddScreen.route){
                            popUpTo(Screens.IncomeScreen.route){
                                inclusive = true
                            }
                        } },
                         { navController.navigate(Screens.MainMenuSelectScreen.route){
                            popUpTo(Screens.IncomeScreen.route){
                                inclusive = true
                            }
                        }},
                        viewModel = viewModel
                    )
                }
                composable(route = Screens.ExpensesScreen.route){
                    ExpensesScreen({navController.navigate(Screens.ExpensesAddScreen.route){
                        popUpTo(Screens.ExpensesScreen.route){
                            inclusive = true
                        }
                    } },
                        {navController.navigate(Screens.MainMenuSelectScreen.route){
                            popUpTo(Screens.ExpensesScreen.route){
                                inclusive = true
                            }
                        } },
                        expensesScreenViewModel)
                }
                composable(route = Screens.IncomeAddScreen.route){
                    IncomeAddScreen(
                        navController,
                        viewModel = viewModel,
                        onIncomeAdded = {  navController.navigate(Screens.IncomeScreen.route){
                            popUpTo(Screens.IncomeAddScreen.route){
                                inclusive = true
                            }
                        } }
                    )
                }
                composable(route = Screens.ExpensesAddScreen.route){
                    ExpensesAddScreen(navController, expensesScreenViewModel,
                        onExpensesAdded = {navController.navigate(Screens.ExpensesScreen.route){
                        popUpTo(Screens.ExpensesAddScreen.route){
                            inclusive = true
                        }
                    }})
                }
            }
        }
    }
}
