package com.studying.howistheweather.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.repositories.IHomeRepository
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: IHomeRepository) : ViewModel() {

    private val _weatherData = MutableLiveData<OpenWeatherResponse>()
    val weatherData: LiveData<OpenWeatherResponse> get() = _weatherData

    private val _weatherDataErrorResponse = MutableLiveData<String>()
    val weatherDataErrorResponse: LiveData<String?> get() = _weatherDataErrorResponse

    fun getWeathers(
        city: String
    ) = viewModelScope.launch{
        try {
            val response = repository.getWeather(city)
            _weatherData.value = response
        } catch (error: Exception){
            _weatherDataErrorResponse.value = error.toString()

        }
    }

}