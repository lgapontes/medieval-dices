package com.lgapontes.medievaldices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var editTextAmount: EditText
    lateinit var editTextResult: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAmount = findViewById(R.id.edittext_amount) as EditText
        editTextResult = findViewById(R.id.edittext_result) as EditText

        var buttonMinus = findViewById(R.id.button_minus) as Button
        buttonMinus.setOnClickListener {
            var value: Int = editTextAmount.text.toString().toInt()
            if (value > 1) {
                value = value - 1
            }
            var s: String = value.toString()
            editTextAmount.setText(s)
        }
        var buttonPlus = findViewById(R.id.button_plus) as Button
        buttonPlus.setOnClickListener {
            var value: Int = editTextAmount.text.toString().toInt()
            if (value < 20) {
                value = value + 1
            }
            var s: String = value.toString()
            editTextAmount.setText(s)
        }

        var buttonD4 = findViewById(R.id.button_d4) as Button
        buttonD4.setOnClickListener {
            calcResult(4)
        }
        var buttonD6 = findViewById(R.id.button_d6) as Button
        buttonD6.setOnClickListener {
            calcResult(6)
        }
        var buttonD8 = findViewById(R.id.button_d8) as Button
        buttonD8.setOnClickListener {
            calcResult(8)
        }
        var buttonD10 = findViewById(R.id.button_d10) as Button
        buttonD10.setOnClickListener {
            calcResult(10)
        }
        var buttonD12 = findViewById(R.id.button_d12) as Button
        buttonD12.setOnClickListener {
            calcResult(12)
        }
        var buttonD20 = findViewById(R.id.button_d20) as Button
        buttonD20.setOnClickListener {
            calcResult(20)
        }
    }

    private fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start

    private fun calcResult(dice: Int) {
        var amount: Int = editTextAmount.text.toString().toInt()

        var total: Int = 0

        var result: String = "Dices: "
        var index = 0
        while (index < amount) {
            var value = (1..dice).random()
            total += value
            result += value.toString()
            if ( (index + 1) < amount) {
                result += " + "
            }
            index++
        }

        editTextResult.setText("Result: $total\n$result")
    }
}
