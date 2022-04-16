package com.studying.howistheweather.webClient

import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {
    @GET("data/2.5/weather?")
    fun getWeather(
        @Query("q") city: String,
        @Query("APPID") app_id: String = API_KEY,
        @Query("units") units: String = "metric",
    ): Call<OpenWeatherResponse>

    companion object {
        val API_KEY = "432f4ecb34bf9c7e07b49597738ffb52"
        val BASE_URL = "https://api.openweathermap.org/"
    }


}