package com.example.new_task.api

import com.example.new_task.model.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeatherForCity(@Query ("appID")appId:String,
                          @Query("q") cityName:String):Call<WeatherResult>
}