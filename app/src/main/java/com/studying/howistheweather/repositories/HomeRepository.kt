package com.studying.howistheweather.repositories

import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.webClient.OpenWeatherService

class HomeRepository(
    private val retrofitService: OpenWeatherService,
) : IHomeRepository {

    override suspend fun getWeather(city: String) : OpenWeatherResponse {

        try {
            return retrofitService.getWeather(city)
        } catch (error: Exception){
            throw error
        }
    }

    fun saveWeather(weather: OpenWeatherResponse){

    }

    fun getAllWeathers(): MutableList<OpenWeatherResponse> {
        return mutableListOf()
    }



}