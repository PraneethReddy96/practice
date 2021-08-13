package com.praneeth.assesment.repository
import androidx.lifecycle.LiveData
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.model.DummyResponse
import com.praneeth.assesment.remote.ApiResponse
import com.praneeth.assesment.remote.RetrofitBuilder
import retrofit2.Response

class Repository {


  val apiClient = RetrofitBuilder.getInstance().create(ApiResponse::class.java)
  val responseHandler = RetrofitNetworkRequestHandler.ResponseHandler()



  suspend fun getApiData(): DataItem?{


    val response = apiClient.getResponse().data?.get(0)

   return response

  }







}