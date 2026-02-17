package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        tvCounter = findViewById(R.id.textView)
        val btnAdd: Button = findViewById(R.id.button)
        val btnReset: Button = findViewById(R.id.buttonReset)
        val btnRemove: Button = findViewById(R.id.buttonRemove)
        val btnNext: Button = findViewById(R.id.buttonNext)

        // Initialize counter display
        tvCounter.text = count.toString()

        // Increment button
        btnAdd.setOnClickListener {
            count++
            tvCounter.text = count.toString()
        }

        // Remove button (prevent negative)
        btnRemove.setOnClickListener {
            if (count > 0) {
                count--
                tvCounter.text = count.toString()
            }
        }

        // Reset button
        btnReset.setOnClickListener {
            count = 0
            tvCounter.text = count.toString()
        }

        // Next button (navigate to WelcomeScreen)
        btnNext.setOnClickListener {
            val intent = Intent(this, WelcomeScreen::class.java)
            startActivity(intent)
        }
    }
}
