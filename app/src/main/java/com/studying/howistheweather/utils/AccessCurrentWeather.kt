package com.studying.howistheweather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.studying.howistheweather.R
import com.studying.howistheweather.databinding.AccessCurrentWeatherBinding

class AccessCurrentWeather @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    private val binding =
        AccessCurrentWeatherBinding.inflate(LayoutInflater.from(context), this, true)

    var listener: AccessCurrentWeatherListener? = null

    init {
        clickCardViewListener()
    }

    fun setIsFavorite() {
        binding.favoriteIconImageView.setBackgroundResource(R.drawable.is_favorite)
    }

    fun setIsNotFavorite() {
        binding.favoriteIconImageView.setBackgroundResource(R.drawable.is_not_favorite)
    }

    fun setCityName(cityName: String) {
        binding.cityTextView.text = cityName
    }

    fun setTemperature(temperatureValue: Double) {
        binding.temperatureTextView.text = temperatureValue.toString()
    }

    fun setWeatherImage(weatherImage: Int) {
        binding.weatherImageView.setBackgroundResource(weatherImage)
    }

    fun setNameWeather(weatherName: String) {
        binding.weatherNameTextView.text = weatherName
    }

    private fun clickCardViewListener() {
        binding.currentWeatherButton.setOnClickListener {
            listener?.setCardViewImplementation()
        }
        binding.favoriteIconImageView.setOnClickListener {
            listener?.setFavoriteState()
        }
    }
}

interface AccessCurrentWeatherListener {
    fun setFavoriteState()
    fun setCardViewImplementation()
}