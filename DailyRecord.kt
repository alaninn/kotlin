package com.alan.appdiariolocal

import java.io.Serializable

data class DailyRecord(
    val date: String,
    val expenses: List<Pair<String, Long>>, // Cambiado de Double a Long
    val cashSales: Long, // Cambiado de Double a Long
    val onlineSales: Long // Cambiado de Double a Long
) : Serializable {
    val totalExpenses: Int // Cambiado de Double a Int
        get() = expenses.sumBy { it.second.toInt() } // Convertir los valores Long a Int antes de sumarlos
}
