    package com.alan.appdiariolocal
    import java.io.Serializable

    data class DailyRecord(
        val date: String,
        val expenses: List<Pair<String, Double>>,
        val cashSales: Double,
        val onlineSales: Double
    ) : Serializable {
        val totalExpenses: Double
            get() = expenses.sumByDouble { it.second }
    }
