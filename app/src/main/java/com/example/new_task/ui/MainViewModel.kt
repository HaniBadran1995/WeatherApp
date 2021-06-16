package com.example.new_task.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.new_task.api.ApiController
import com.example.new_task.model.WeatherResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application): AndroidViewModel(application) {
    val weatherData: MutableLiveData<ArrayList<WeatherResult?>> = MutableLiveData(ArrayList())

    fun callWeatherApi(names: ArrayList<String>, appID:String){
        val callback= object :Callback<WeatherResult>{
            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                try {
                    val list= weatherData.value
                    list?.add(response?.body())
                    weatherData.postValue(list)

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                t.printStackTrace()
            }
        }

        names.forEach {name->
            ApiController.callWeatherApi(appID,name,callback)
        }
    }
}