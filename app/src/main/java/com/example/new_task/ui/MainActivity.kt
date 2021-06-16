package com.example.new_task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new_task.R
import com.example.new_task.model.WeatherResult


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdapter
    lateinit var layoutManger: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler() {
        recyclerView=findViewById(R.id.my_recycler);
        layoutManger= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.layoutManager= layoutManger
        adapter= DataAdapter(ArrayList())
        recyclerView.adapter=adapter;
        val divider= DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(divider)

    }

    private fun initViewModel(){
        viewModel.weatherData.observe(this,object :Observer<ArrayList<WeatherResult?>>{
            override fun onChanged(list: ArrayList<WeatherResult?>) {
                // todo set adapter list and call notifyDatasetChanged
                adapter.myList=list

                adapter.notifyDataSetChanged()
            }
        })

        viewModel.callWeatherApi(arrayListOf("Amman","Irbid","Aqaba"), getString(R.string.api_app_id))
    }
}