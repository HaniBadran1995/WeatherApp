package com.example.new_task.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_task.R
import com.example.new_task.model.WeatherResult

class DataAdapter(var myList :ArrayList<WeatherResult?>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var main=itemView.findViewById(R.id.main) as TextView
        var description=itemView.findViewById(R.id.description) as TextView
        var cityNameTxt= itemView.findViewById(R.id.city_name_text) as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var data= myList.get(position)
        data?.let{
            val weather= it.weatherList.first()
            holder.main.text=weather.main
            holder.description.text=weather.desc
            holder.cityNameTxt.text= it.name

        }
    }
}