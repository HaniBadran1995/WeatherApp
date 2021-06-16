package com.example.new_task.model

import com.example.new_task.model.TemperatureModel
import com.example.new_task.model.WindModel
import com.google.gson.annotations.SerializedName

data class WeatherResult(
    @SerializedName("weather") val weatherList: List<WeatherModel>,
    @SerializedName("name") val name:String,
    @SerializedName("main") val temp: TemperatureModel,
    @SerializedName("wind") val wind: WindModel
    )
