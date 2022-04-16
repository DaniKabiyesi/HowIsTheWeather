package com.studying.howistheweather.ui.onboarding.screens

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studying.howistheweather.ui.LoginScreenActivity
import com.studying.howistheweather.databinding.FragmentThirdScreenOnboardingBinding

class ThirdScreenOnboarding : Fragment() {

    private lateinit var _binding: FragmentThirdScreenOnboardingBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentThirdScreenOnboardingBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.run {
            nextScreenButton.setOnClickListener {
                nextScreen()
            }
        }
    }

    private fun nextScreen() {
        val intent = Intent(context, LoginScreenActivity::class.java)
        startActivity(intent)

    }
}