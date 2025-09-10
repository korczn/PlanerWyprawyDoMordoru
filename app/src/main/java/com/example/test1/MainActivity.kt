package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    val rasy = arrayOf("Człowiek", "Goblin", "Obcy", "Starszy", "Inny")

    override fun onCreate(savedInstanceState: Bundle?) {

        val showDatePickerButton: Button = findViewById(R.id.open_datepicker_button)
        showDatePickerButton.setOnClickListener {
            showDatePickerDialog()

        }

            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)

            val spinner: Spinner = findViewById(R.id.spinner1)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, rasy)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedRace = rasy[position]
                    Toast.makeText(this@MainActivity, "Wybrałeś: $selectedRace", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,{_, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedYear/${selectedMonth+1}/$selectedDay"
            Toast.makeText(this, "Wybrano: $selectedDate", Toast.LENGTH_LONG).show()
        }, year, month, day)

        datePickerDialog.show()
    }

}
