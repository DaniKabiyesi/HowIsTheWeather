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

    fun setHumidity(humidityValue: Int) {
        binding.humidityNumberTextView.text = humidityValue.toString()
    }

    fun setPressure(pressureValue: Int) {
        binding.pressureNumberTextView.text = pressureValue.toString()
    }

    fun setWindSpeed(windSpeedValue: Double) {
        binding.windSpeedNumberTextView.text = windSpeedValue.toString()
    }

    fun setTempMax(tempMaxValue: Double) {
        binding.tempMaxNumberTextView.text = tempMaxValue.toString()
    }

    fun setTempMin(tempMinValue: Double) {
        binding.tempMinNumberTextView.text = tempMinValue.toString()
    }

    fun setWeatherName(string: String){
        binding.weatherNameTextView.text = string
    }
}
