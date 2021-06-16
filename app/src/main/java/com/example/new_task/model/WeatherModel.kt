package com.example.new_task.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(@SerializedName("main")val main:String, @SerializedName("description") val desc:String)
