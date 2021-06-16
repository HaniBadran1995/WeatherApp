package com.example.new_task.model

import com.google.gson.annotations.SerializedName

data class WindModel(
    @SerializedName("speed") val speed: Float,
    @SerializedName("deg") val degree:Float
)
