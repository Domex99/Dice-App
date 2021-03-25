package com.example.dicecupcompulsory

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    private val diceId = intArrayOf(
            0, R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    )
    private val mHistory = mutableListOf<Pair<String, List<Int>>>()

    private val mRandomGenerator = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BtnRoll.setOnClickListener { v -> onClickRoll() }
        BtnHistory.setOnClickListener { v -> onClickHistory() }
        populateSpinner()
    }

    private fun onClickRoll() {
        val list = mutableListOf<Int>()
        val current = now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = current.format(formatter)

        if (SpDices.selectedItemPosition == 0) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            mHistory.add(Pair(formatted, list))

        }
        if (SpDices.selectedItemPosition == 1) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            list.add(e2)
            mHistory.add(Pair(formatted, list))
        }
        if (SpDices.selectedItemPosition == 2) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            list.add(e2)
            list.add(e3)
            mHistory.add(Pair(formatted, list))
        }
        if (SpDices.selectedItemPosition == 3) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            list.add(e2)
            list.add(e3)
            list.add(e4)
            mHistory.add(Pair(formatted, list))
        }
        if (SpDices.selectedItemPosition == 4) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            val e5 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            list.add(e2)
            list.add(e3)
            list.add(e4)
            list.add(e5)
            mHistory.add(Pair(formatted, list))
        }
        if (SpDices.selectedItemPosition == 5) {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            val e5 = mRandomGenerator.nextInt(6) + 1
            val e6 = mRandomGenerator.nextInt(6) + 1
            list.add(e1)
            list.add(e2)
            list.add(e3)
            list.add(e4)
            list.add(e5)
            list.add(e6)
            mHistory.add(Pair(formatted, list))
        }
        updateDicesWith(list)
        // updateHistory()
    }

    private fun onClickHistory() {
        val i = Intent(this, HistoryActivity::class.java)
        i.putExtra("history", mHistory.toTypedArray())
        startActivityForResult(i, 5)
    }

    private fun updateDicesWith(list: List<Int>) {
        if (list.size == 1) {
            imgDice1.setImageResource(diceId[list.first()])
        }
        if (list.size == 2) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
        }
        if (list.size == 3) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
        }
        if (list.size == 4) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
        }
        if (list.size == 5) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
            imgDice5.setImageResource(diceId[list.get(4)])
        }
        if (list.size == 6) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
            imgDice5.setImageResource(diceId[list.get(4)])
            imgDice6.setImageResource(diceId[list.get(5)])
        }

    }

    private fun populateSpinner() {
        ArrayAdapter.createFromResource(
                this,
                R.array.dices,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            SpDices.adapter = adapter

            SpDices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                ) {
                    when (position) {
                        0 -> {
                            imgDice2.isVisible = false
                            imgDice3.isVisible = false
                            imgDice4.isVisible = false
                            imgDice5.isVisible = false
                            imgDice6.isVisible = false
                        }
                        1 -> {
                            imgDice2.isVisible = true
                            imgDice3.isVisible = false
                            imgDice4.isVisible = false
                            imgDice5.isVisible = false
                            imgDice6.isVisible = false
                        }
                        2 -> {
                            imgDice2.isVisible = true
                            imgDice3.isVisible = true
                            imgDice4.isVisible = false
                            imgDice5.isVisible = false
                            imgDice6.isVisible = false
                        }
                        3 -> {
                            imgDice2.isVisible = true
                            imgDice3.isVisible = true
                            imgDice4.isVisible = true
                            imgDice5.isVisible = false
                            imgDice6.isVisible = false
                        }
                        4 -> {
                            imgDice2.isVisible = true
                            imgDice3.isVisible = true
                            imgDice4.isVisible = true
                            imgDice5.isVisible = true
                            imgDice6.isVisible = false
                        }
                        5 -> {
                            imgDice2.isVisible = true
                            imgDice3.isVisible = true
                            imgDice4.isVisible = true
                            imgDice5.isVisible = true
                            imgDice6.isVisible = true
                        }
                    }

                }
            }
        }
    }

    private fun updateHistory() {
        var s = ""
        mHistory.forEach { p ->
            val e1 = p.first;
            val e2 = p.second; s += "$e1 - $e2 \n"
        }
        tvHistory.text = s
    }

    fun clearHistory(view: View) {
        mHistory.clear()
        updateHistory()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 5) {
            if (resultCode == 10)
                mHistory.clear()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("history", mHistory.toTypedArray())
    }
}





