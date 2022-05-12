package com.studying.howistheweather.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studying.howistheweather.R

class CurrentWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val weatherName: TextView = itemView.findViewById(R.id.weatherNameTextView)
    val humidityNumber: TextView = itemView.findViewById(R.id.humidityNumberTextView)
    val pressureNumber: TextView = itemView.findViewById(R.id.pressureNumberTextView)
    val windSpeedNumber: TextView = itemView.findViewById(R.id.windSpeedNumberTextView)
    val tempMaxNumber: TextView = itemView.findViewById(R.id.tempMaxNumberTextView)
    val tempMinNumber: TextView = itemView.findViewById(R.id.tempMinNumberTextView)
}