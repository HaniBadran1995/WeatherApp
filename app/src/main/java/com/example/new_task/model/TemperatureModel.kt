package com.example.new_task.model

import com.google.gson.annotations.SerializedName

data class TemperatureModel(
    @SerializedName("temp") val temp:Float,
    @SerializedName("temp_min") val tempMin:Float,
    @SerializedName("temp_max") val tempMax:Float,
    @SerializedName("pressure") val pressure:Float,
    @SerializedName("humidity") val humidity:Float

)
