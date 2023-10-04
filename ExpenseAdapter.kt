package com.alan.appdiariolocal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alan.appdiariolocal.R

class ExpenseAdapter(private val expenses: List<Pair<String, Double>>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textExpenseName)
        val valueTextView: TextView = itemView.findViewById(R.id.textExpenseValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expense_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.nameTextView.text = expense.first
        holder.valueTextView.text = expense.second.toString()
    }

    override fun getItemCount(): Int {
        return expenses.size
    }
}
