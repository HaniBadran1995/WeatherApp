
package com.example.new_task.api

import com.example.new_task.model.WeatherResult
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiController {
    var BASE_URL: String = "https://api.openweathermap.org/data/2.5/"

    val getClient:ApiService
        get() {
            val gson= GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiService::class.java)
        }

    fun callWeatherApi(appID:String, cityName:String, callback: Callback<WeatherResult>){
        val call= getClient.getWeatherForCity(appID,cityName)
        call.enqueue(callback)
    }
}