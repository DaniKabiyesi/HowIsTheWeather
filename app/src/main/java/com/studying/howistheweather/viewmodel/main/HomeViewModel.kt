package com.studying.howistheweather.viewmodel.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studying.howistheweather.adapter.CurrentWeatherAdapter
import com.studying.howistheweather.adapter.CurrentWeatherAdapterInterface
import com.studying.howistheweather.databinding.ActivityHomeScreenBinding
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.repositories.HomeRepository
import com.studying.howistheweather.ui.WeatherInfoActivity
import com.studying.howistheweather.webClient.OpenWeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: HomeRepository) : ViewModel() {

    lateinit var binding: ActivityHomeScreenBinding

    private val _weatherList = MutableLiveData<List<OpenWeatherResponse>>()
    val weatherList: LiveData<List<OpenWeatherResponse>> get() = _weatherList

    private val _weatherListErrorResponse = MutableLiveData<String>()
    val weatherListErrorResponse: LiveData<String?> get() = _weatherListErrorResponse

    suspend fun getWeathers(
        city: String,
        app_id: String,
        units: String,
    ) = withContext(Dispatchers.Main) {

        val call: Call<OpenWeatherResponse> = repository.getWeather(city, app_id, units)
        call.enqueue(object : Callback<OpenWeatherResponse> {
            override fun onResponse(
                call: Call<OpenWeatherResponse>,
                response: Response<OpenWeatherResponse>,
            ) {
                if (response.isSuccessful) {
//                    _weatherList.postValue(listOf(response.body()!!))

                }
            }

            override fun onFailure(call: Call<OpenWeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun initRecyclerView(
        list: MutableList<OpenWeatherResponse>,
        context: Context,
    ) {
        setUpRecyclerView(list, binding, context)

    }

    private fun setUpRecyclerView(
        weatherList: MutableList<OpenWeatherResponse>,
        binding: ActivityHomeScreenBinding,
        context: Context,
    ) {
        val weatherAdapter = CurrentWeatherAdapter(context, weatherList)
        val recyclerWeather = binding.buttonRecyclerView

        weatherAdapter.notify = object : CurrentWeatherAdapterInterface {
            override fun notifyActivity(weather: OpenWeatherResponse) {
                startCurrentWeather(context, weather)
            }
        }
        recyclerWeather.adapter = weatherAdapter
    }

    private fun startCurrentWeather(context: Context, weather: OpenWeatherResponse) {
        val intent = Intent(context, WeatherInfoActivity::class.java)
        intent.putExtra("coin", weather)
        context.startActivity(intent)
    }
}