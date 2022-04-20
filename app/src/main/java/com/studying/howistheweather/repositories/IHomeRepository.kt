package com.studying.howistheweather.repositories

import com.studying.howistheweather.models.apiModel.OpenWeatherResponse

interface IHomeRepository {
    suspend fun getWeather(city: String) : OpenWeatherResponse
}