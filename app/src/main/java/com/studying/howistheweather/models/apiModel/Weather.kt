package com.studying.howistheweather.models.apiModel

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)