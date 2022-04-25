package com.studying.howistheweather.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.repositories.IHomeRepository
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: IHomeRepository) : ViewModel() {

    private val _weatherList = MutableLiveData<OpenWeatherResponse>()
    val weatherList: LiveData<OpenWeatherResponse> get() = _weatherList

    private val _weatherListErrorResponse = MutableLiveData<String>()
    val weatherListErrorResponse: LiveData<String?> get() = _weatherListErrorResponse

    fun getWeathers(
        city: String
    ) = viewModelScope.launch {
        try {
            val response = repository.getWeather(city)
            _weatherList.value = response
        } catch (error: Exception){
            _weatherListErrorResponse.value = error.toString()

        }
    }





//    private fun startCurrentWeather(context: Context, weather: OpenWeatherResponse) {
//        val intent = Intent(context, WeatherInfoActivity::class.java)
//        intent.putExtra("coin", weather)
//        context.startActivity(intent)
//    }
}