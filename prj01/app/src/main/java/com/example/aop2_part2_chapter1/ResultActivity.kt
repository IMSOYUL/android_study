package com.example.aop2_part2_chapter1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height: $height weight: $weight")

        val bmi = weight / (height / 100.0).pow(2.0)

        val typeOfObesity = when {
            bmi >= 35.0 -> "고도비만"
            bmi >= 30.0 -> "중정도비만"
            bmi >= 25.0 -> "경도비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val typeOfObesityTextView = findViewById<TextView>(R.id.typeOfObesityResultTextView)
        val bmiResultTextView = findViewById<TextView>(R.id.bmiResultTextView)

        typeOfObesityTextView.text = typeOfObesity
        bmiResultTextView.text = bmi.toString()

    }
}