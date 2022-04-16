package com.studying.howistheweather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.studying.howistheweather.R
import com.studying.howistheweather.utils.AccessCurrentWeather
import com.studying.howistheweather.utils.AccessCurrentWeatherListener
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse

class CurrentWeatherAdapter(
    private val context: Context,
    private var currentWeather: MutableList<OpenWeatherResponse>,
) : RecyclerView.Adapter<CurrentWeatherAdapter.CurrentWeatherViewHolder>() {

    fun setWeathersList(weathers: List<OpenWeatherResponse>){
        this.currentWeather = currentWeather.toMutableList()
        notifyDataSetChanged()
    }

    var notify: CurrentWeatherAdapterInterface? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CurrentWeatherViewHolder {
        val weatherView = LayoutInflater.from(context).inflate(R.layout.weather_list, parent, false)
        return this.CurrentWeatherViewHolder(weatherView)
    }

    override fun onBindViewHolder(
        holder: CurrentWeatherViewHolder,
        position: Int,
    ) {
        val weather = currentWeather[position]
        holder.weatherList.setCityName(weather.name)
        holder.weatherList.setNameWeather(weather.weather[0].main)
        holder.weatherList.setTemperature(weather.main.temp)

        if (weather.favorite) {
            holder.weatherList.setIsFavorite()
        } else {
            holder.weatherList.setIsNotFavorite()
        }

        holder.weatherList.listener = object : AccessCurrentWeatherListener {
            override fun setFavoriteState() {
                weather.favorite = !weather.favorite
                notifyItemChanged(holder.adapterPosition)
            }

            override fun setCardViewImplementation() {
                notify?.notifyActivity(weather)
            }

        }

    }

    override fun getItemCount(): Int = currentWeather.size

    inner class CurrentWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weatherList: AccessCurrentWeather =
            itemView.findViewById(R.id.listAccessCurrentWeather)
    }

}

interface CurrentWeatherAdapterInterface {
    fun notifyActivity(weather: OpenWeatherResponse)
}