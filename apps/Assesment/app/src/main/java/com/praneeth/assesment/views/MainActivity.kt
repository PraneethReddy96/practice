package com.praneeth.assesment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.praneeth.assesment.R
import com.praneeth.assesment.adapters.dummyAdapter
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.viewmodel.myViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: myViewModel
    private var dataList = mutableListOf<DataItem>()
    private lateinit var dummyRecyclerView: RecyclerView
    private lateinit var dummyAdapter: dummyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setRecylerAdapter()
        fetchData()

    }

    private fun fetchData() {

        viewModel.getDataFromRepository().observe(this, Observer {

            dataList.clear()
            dataList.addAll(it)
            dummyAdapter.notifyDataSetChanged()


        })

    }

    private fun setRecylerAdapter() {

        val llManager = LinearLayoutManager(this)
        dummyRecyclerView.layoutManager = llManager
        dummyAdapter = dummyAdapter(dataList)
        dummyRecyclerView.adapter = dummyAdapter




    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(myViewModel::class.java)
        dummyRecyclerView = findViewById(R.id.rvDummyResponseRecyclerView)
    }


}