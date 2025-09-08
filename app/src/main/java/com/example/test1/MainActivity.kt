package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val showDatePickerButton: Button = findViewById(R.id.open_datepicker_button)
//        showDatePickerButton.setOnClickListener {
//            showDatePickerDialog()
//
//            val timePicker = findViewById<TimePicker>(R.id.spinner_timepicker)
//            timePicker.setIs24HourView(true)
//
//            timePicker.setOnTimeChangedListener { view, hour, minute ->
//                val selectedTime = "$hour:$minute"
//                view.setBackgroundColor(Color.CYAN)
//                Toast.makeText(this, "Wybrana godzina: $selectedTime", Toast.LENGTH_SHORT).show()
            }

        }
