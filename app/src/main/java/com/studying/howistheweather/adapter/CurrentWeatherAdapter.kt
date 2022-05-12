package com.studying.howistheweather.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.studying.howistheweather.R
import com.studying.howistheweather.extensions.inflate
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse

class CurrentWeatherAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var adapterList: MutableList<OpenWeatherResponse> = mutableListOf()

    override fun getItemCount(): Int = adapterList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CurrentWeatherViewHolder {
        val weatherView = parent.inflate(R.layout.access_current_weather)
        return CurrentWeatherViewHolder(weatherView)
    }

    fun populateAdapter(weatherList: MutableList<OpenWeatherResponse>){
        this.adapterList = weatherList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as CurrentWeatherViewHolder
        val entity = adapterList[position]

        bindItemViewHolder(itemViewHolder, entity, position)
    }

    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(
        viewHolder: CurrentWeatherViewHolder,
        item: OpenWeatherResponse,
        position: Int,
    ) {
        viewHolder.weatherName.text = item.weather[0].main
        viewHolder.humidityNumber.text = "${item.main.humidity}%"
        viewHolder.pressureNumber.text = "${item.main.pressure}mb"
        viewHolder.windSpeedNumber.text = "${item.wind.speed} Km/H"
        viewHolder.tempMaxNumber.text = "${item.main.temp_max} °C"
        viewHolder.tempMinNumber.text = "${item.main.temp_min} °C"
    }

}
