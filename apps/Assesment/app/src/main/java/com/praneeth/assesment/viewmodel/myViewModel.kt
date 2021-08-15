package com.praneeth.assesment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.model.repository.Repository
import kotlinx.coroutines.Dispatchers

class myViewModel : ViewModel() {


    val repository = Repository()


    fun getDataFromRepository(): LiveData<List<DataItem>> {


        return liveData(Dispatchers.IO) {

            repository.getApiData()

        }


    }

}