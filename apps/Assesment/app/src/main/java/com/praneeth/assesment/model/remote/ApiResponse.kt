package com.praneeth.assesment.model.remote

import com.praneeth.assesment.model.DummyResponse
import retrofit2.http.GET


interface ApiResponse {


    @GET("/api/v1/employees")
    suspend fun getResponse() : DummyResponse

}