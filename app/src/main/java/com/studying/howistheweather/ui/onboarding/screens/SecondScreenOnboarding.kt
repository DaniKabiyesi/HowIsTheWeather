package com.studying.howistheweather.ui.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.studying.howistheweather.R
import com.studying.howistheweather.databinding.FragmentSecondScreenOnboardingBinding

class SecondScreenOnboarding : Fragment() {

    private lateinit var _binding: FragmentSecondScreenOnboardingBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentSecondScreenOnboardingBinding.inflate(
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
        findNavController().navigate(R.id.action_secondScreenOnboarding_to_thirdScreenOnboarding)

    }
}