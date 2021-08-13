package com.praneeth.assesment.remote

import androidx.lifecycle.LiveData
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.model.DummyResponse
import retrofit2.http.GET


interface ApiResponse {


    @GET("/api/v1/employees")
    suspend fun getResponse() : DummyResponse

}