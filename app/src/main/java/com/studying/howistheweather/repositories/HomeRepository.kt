package com.studying.howistheweather.repositories

import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.webClient.OpenWeatherService
import retrofit2.Call

class HomeRepository(
    private val retrofitService: OpenWeatherService,
) {

    fun getWeather(city: String, app_id: String, units: String) : Call<OpenWeatherResponse> =
        retrofitService.getWeather(city, app_id, units)


}