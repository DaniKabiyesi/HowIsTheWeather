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
        with(binding) {
            logoImageView.alpha = 0f
            firstTextView.alpha = 0f
            secondTextView.alpha = 0f


            firstTextView.animate().setDuration(1500).alpha(1f)
            secondTextView.animate().setDuration(1500).alpha(1f)
            logoImageView.animate().setDuration(1500).alpha(1f).withEndAction {
                val intent = Intent(this@SplashScreenActivity, OnboardingActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
    }