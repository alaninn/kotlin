package com.alan.appdiariolocal
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DailyRecordAdapter(private val dailyRecords: List<DailyRecord>) :
    RecyclerView.Adapter<DailyRecordAdapter.ViewHolder>() {

    private var onItemClickListener: ((Int) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.textDate)
        // Puedes agregar más vistas aquí para otros detalles de la nota diaria

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_record_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dailyRecord = dailyRecords[position]
        holder.dateTextView.text = "Diario - ${dailyRecord.date}"
        // Configura otras vistas aquí con datos de dailyRecord
    }

    override fun getItemCount(): Int {
        return dailyRecords.size
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }
}
