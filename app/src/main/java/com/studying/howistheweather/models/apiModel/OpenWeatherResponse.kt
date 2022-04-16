package com.studying.howistheweather.models.apiModel

import java.io.Serializable

data class OpenWeatherResponse(
//    val id: Int,
    val main: Main,
    val name: String,
    val weather: List<Weather>,
    var favorite: Boolean = false
) : Serializable {

    fun toOpenWeatherList() : OpenWeatherResponse {
        return OpenWeatherResponse(
            name = name,
            weather = weather,
            main = main,
        )
    }


}