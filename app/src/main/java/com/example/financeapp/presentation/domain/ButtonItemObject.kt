package com.example.financeapp.presentation.domain

import com.example.financeapp.R
import com.example.financeapp.presentation.domain.model.ButtonItem

object ButtonItemObject {
    fun getButtonItem(): List<ButtonItem>{
        return listOf(
            ButtonItem(R.drawable.passive_income, "INCOME"),
            ButtonItem(R.drawable.poor, "EXPENSES"),
            ButtonItem(R.drawable.budget, "FINANCE"),
        )
    }

}