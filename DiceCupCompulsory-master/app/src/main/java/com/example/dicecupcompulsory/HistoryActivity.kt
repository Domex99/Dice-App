package com.example.dicecupcompulsory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        if (intent.extras?.getSerializable("history") != null) {
            val historyList = intent.extras?.getSerializable("history") as Array<Pair<String, List<Int>>>

            val adapter: ListAdapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1, historyList
            )
            history_list_view.adapter = adapter
        }
        BtnBack.setOnClickListener { v -> onClickBack() }
        BtnClear.setOnClickListener { v -> onClickCLear() }
    }

    private fun onClickBack() {
        finish()
    }

    private fun onClickCLear() {
        setResult(10)
        finish()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}