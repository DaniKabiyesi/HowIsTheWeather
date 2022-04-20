//package com.studying.howistheweather.di
//
//import com.studying.howistheweather.repositories.HomeRepository
//import com.studying.howistheweather.webClient.OpenWeatherService
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//val retrofitModule = module {
//    factory<Interceptor>{
//        HttpLoggingInterceptor(
//            HttpLoggingInterceptor.Logger.DEFAULT
//        ).setLevel(
//            HttpLoggingInterceptor.Level.BODY
//        )
//    }
//
//    factory {
//        OkHttpClient.Builder().addInterceptor(
//            interceptor = get()
//        ).build()
//    }
//
//    single {
//        Retrofit.Builder()
//            .client(get())
//            .baseUrl(OpenWeatherService.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(CoroutineCall)
//    }
//}