package com.studying.howistheweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studying.howistheweather.databinding.ActivityNewWeatherCityBinding

class CityWeatherInfoActivity : AppCompatActivity() {

    lateinit var binding : ActivityNewWeatherCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWeatherCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}