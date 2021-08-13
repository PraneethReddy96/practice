package com.praneeth.assesment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.model.DummyResponse
import com.praneeth.assesment.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myViewModel : ViewModel() {


    val repository = Repository()

    fun getDataFromRepository(): LiveData<List<DataItem>> {


        return  liveData(Dispatchers.IO) {

            repository.getApiData()

        }


    }

}