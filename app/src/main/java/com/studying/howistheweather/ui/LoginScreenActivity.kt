package com.studying.howistheweather.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.studying.howistheweather.databinding.ActivityLoginScreenBinding
import com.studying.howistheweather.viewmodel.login.LoginViewModel
import com.studying.howistheweather.viewmodel.login.LoginViewModelFactory

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModelFactory())[LoginViewModel::class.java]
        setListeners()
    }

    private fun userVerification(viewState: LoginViewModel.ViewState?) {
        when (viewState) {
            LoginViewModel.ViewState.SUCCESS -> {
                nextScreen()
            }
            LoginViewModel.ViewState.ERROR -> {
                errorToast()
            }

            null -> {
                errorToast()
            }
        }
    }

    private fun errorToast() {
        Toast.makeText(this, "Please, type your login and password", Toast.LENGTH_SHORT).show()
    }

    private fun setListeners() = with(binding) {
        accessButton.setOnClickListener {
            userVerification(
                viewModel.signValidation(
                    binding.loginEditText.text(),
                    binding.passwordEditText.text()
                )
            )
        }
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