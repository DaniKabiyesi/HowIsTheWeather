package com.studying.howistheweather.models.apiModel

import java.io.Serializable

data class OpenWeatherResponse(
    val main: Main,
    val name: String,
    val weather: List<Weather>,
    val wind: Wind,
    var favorite: Boolean = false
) : Serializable {


}