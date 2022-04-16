package com.studying.howistheweather.webClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface WeatherHomeRetrofit {

    companion object {
        private val retrofitService: OpenWeatherService by lazy {
            val retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(OpenWeatherService::class.java)
        }

        fun getInstance(): OpenWeatherService {
            return retrofitService
        }
    }

}