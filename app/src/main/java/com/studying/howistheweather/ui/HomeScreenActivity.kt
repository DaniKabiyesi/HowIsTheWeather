package com.studying.howistheweather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.studying.howistheweather.adapter.CurrentWeatherAdapter
import com.studying.howistheweather.databinding.ActivityHomeScreenBinding
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.viewmodel.home.HomeViewModel
import com.studying.howistheweather.viewmodel.home.HomeViewModelFactory

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    lateinit var viewModel: HomeViewModel
    private val mAdapter = CurrentWeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        viewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]

        setObservers()
        setListeners()
    }

    private fun setUpRecyclerView() {
        val recyclerWeather = binding.currentWeatherCity
        recyclerWeather.adapter = mAdapter
    }

    private fun setObservers() {
        viewModel.weatherData.observe(this) {
            mAdapter.populateAdapter(mutableListOf(it))
            setWeatherInfo(it)
        }

        viewModel.weatherDataErrorResponse.observe(this, Observer {
            errorToast()
        })
    }

    private fun setWeatherInfo(weather: OpenWeatherResponse) {
        binding.apply {
            cityNameTextView.text = weather.name
            temperatureTextView.text = "${weather.main.temp.toInt()}°C"
        }
    }

    private fun setListeners() {
        binding.apply {
            searchBtn.setOnClickListener {
                getCityName()
            }
        }
    }

    private fun getCityName() {
        if (cityNameFieldIsNotBlank()) {
            viewModel.getWeathers(binding.enterYourCityNameEditText.text.toString())
        } else {
            errorToast()
        }
    }

    private fun errorToast() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
    }

    private fun cityNameFieldIsNotBlank() = binding.enterYourCityNameEditText.text.isNotBlank()

}