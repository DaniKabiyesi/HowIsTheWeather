package com.studying.howistheweather.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.howistheweather.databinding.ActivityLoginScreenBinding

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nextScreen()
    }

    private fun nextScreen() {
        binding.run {
            accessButton.setOnClickListener {
                val intent = Intent(
                    this@LoginScreenActivity,
                    HomeScreenActivity::class.java
                )
                startActivity(intent)
                finish()
            }
        }
    }


}