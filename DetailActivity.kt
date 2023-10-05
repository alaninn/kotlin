package com.alan.appdiariolocal



import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DetailActivity : AppCompatActivity() {
    private lateinit var dateTextView: TextView
    private lateinit var totalExpensesTextView: TextView
    private lateinit var cashSalesTextView: TextView
    private lateinit var onlineSalesTextView: TextView
    private lateinit var recyclerViewExpenses: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        dateTextView = findViewById(R.id.textViewDate)
        totalExpensesTextView = findViewById(R.id.textViewTotalExpenses)
        cashSalesTextView = findViewById(R.id.textViewCashSales)
        onlineSalesTextView = findViewById(R.id.textViewOnlineSales)
        val recyclerViewExpenses = findViewById<RecyclerView>(R.id.recyclerViewExpenses)


        val dailyRecord = intent.getSerializableExtra("dailyRecord") as? DailyRecord

        if (dailyRecord != null) {
            dateTextView.text = "Fecha: ${dailyRecord.date}"
            totalExpensesTextView.text = "Gastos Totales: ${dailyRecord.totalExpenses}"
            cashSalesTextView.text = "Ventas en Efectivo: ${dailyRecord.cashSales}"
            onlineSalesTextView.text = "Ventas Virtuales: ${dailyRecord.onlineSales}"

            val expenses = dailyRecord.expenses // Obtener la lista de gastos

            // Configurar el RecyclerView para mostrar la lista de gastos
            recyclerViewExpenses.layoutManager = LinearLayoutManager(this)
            val expenseAdapter = ExpenseAdapter(expenses)
            recyclerViewExpenses.adapter = expenseAdapter
        }
    }
}
