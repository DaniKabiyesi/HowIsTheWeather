package com.studying.howistheweather.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.studying.howistheweather.repositories.HomeRepository
import com.studying.howistheweather.webClient.WeatherHomeRetrofit

class HomeViewModelFactory () : ViewModelProvider.Factory{

    private val retrofitService = WeatherHomeRetrofit.getInstance()

    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            val repository = HomeRepository(retrofitService)
            HomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}