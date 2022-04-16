package com.studying.howistheweather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.studying.howistheweather.adapter.CurrentWeatherAdapter
import com.studying.howistheweather.databinding.ActivityHomeScreenBinding
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.repositories.HomeRepository
import com.studying.howistheweather.viewmodel.main.HomeViewModel
import com.studying.howistheweather.viewmodel.main.HomeViewModelFactory
import com.studying.howistheweather.webClient.WeatherHomeRetrofit

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    lateinit var viewModel: HomeViewModel
    private lateinit var currentWeather: MutableList<OpenWeatherResponse>
    private val retrofitService = WeatherHomeRetrofit.getInstance()
    private val adapter = CurrentWeatherAdapter(this, currentWeather)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, HomeViewModelFactory
                (HomeRepository(retrofitService)))[HomeViewModel::class.java]

//        viewModel.initRecyclerView(viewModelWeatherList() as MutableList<OpenWeatherResponse>, this)

    }

    override fun onStart() {
        super.onStart()

        viewModel.weatherListErrorResponse.observe(this) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()


    }

    private fun viewModelWeatherList() : Unit{
        return viewModel.weatherList.observe(this, Observer{
            adapter.setWeathersList(it)
        })



    }



}