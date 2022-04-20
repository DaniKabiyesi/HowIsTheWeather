package com.studying.howistheweather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studying.howistheweather.adapter.CurrentWeatherAdapter
import com.studying.howistheweather.adapter.CurrentWeatherAdapterInterface
import com.studying.howistheweather.databinding.ActivityHomeScreenBinding
import com.studying.howistheweather.models.apiModel.OpenWeatherResponse
import com.studying.howistheweather.repositories.HomeRepository
import com.studying.howistheweather.viewmodel.main.HomeViewModel
import com.studying.howistheweather.viewmodel.main.HomeViewModelFactory
import com.studying.howistheweather.webClient.WeatherHomeRetrofit

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    lateinit var viewModel: HomeViewModel
    private val currentWeather: MutableList<OpenWeatherResponse> = mutableListOf()
    private val mAdapter = CurrentWeatherAdapter(this, currentWeather)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        viewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]
        setObservers()

        viewModel.getWeathers("Rio de Janeiro")


    }

    private fun setUpRecyclerView() {
        val recyclerWeather = binding.buttonRecyclerView
        recyclerWeather.adapter = mAdapter

//        mAdapter.notify = object : CurrentWeatherAdapterInterface {
//            //            override fun notifyActivity(weather: OpenWeatherResponse) {
////                startCurrentWeather(context, weather)
////            }
//            override fun notifyActivity(weather: OpenWeatherResponse) {
//                star
//            }
//        }

    }


    private fun setObservers() {
        viewModel.weatherList.observe(this) {
            mAdapter.setWeathersList(it)
        }

        viewModel.weatherListErrorResponse.observe(this, Observer {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        })
    }


//    private fun viewModelWeatherList(): Unit {
//        val adapter = CurrentWeatherAdapter(this, currentWeather)
//
//        return viewModel.weatherList.observe(this, Observer {
//            adapter.setWeathersList(it)
//        })
//    }


//
//
//    }


}