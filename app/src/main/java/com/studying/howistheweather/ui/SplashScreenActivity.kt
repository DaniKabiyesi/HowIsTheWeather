package com.studying.howistheweather.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.studying.howistheweather.databinding.ActivitySplashScreenBinding
import com.studying.howistheweather.ui.onboarding.OnboardingActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToNextScreen()
    }

    private fun goToNextScreen() {
        Handler().postDelayed({
            val intent = Intent(
                this,
                OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }, 1600)
    }
}