package com.alan.appdiariolocal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alan.appdiariolocal.AddNoteActivity
import com.alan.appdiariolocal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity(), OnNoteAddedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DailyRecordAdapter
    private lateinit var dailyRecords: MutableList<DailyRecord>

    private val addNoteActivityLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val newRecord = data?.getSerializableExtra("newRecord") as DailyRecord?
                if (newRecord != null) {
                    dailyRecords.add(newRecord)
                    adapter.notifyDataSetChanged()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        dailyRecords = mutableListOf()
        adapter = DailyRecordAdapter(dailyRecords)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener { position ->
            val selectedRecord = dailyRecords[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dailyRecord", selectedRecord)
            startActivity(intent)
        }

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            addNoteActivityLauncher.launch(intent)
        }
    }

    override fun onNoteAdded(note: DailyRecord) {
        dailyRecords.add(note)
        adapter.notifyDataSetChanged()
    }
}
