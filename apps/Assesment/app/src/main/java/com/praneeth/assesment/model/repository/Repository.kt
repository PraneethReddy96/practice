package com.praneeth.assesment.model.repository

import android.util.Log
import com.praneeth.assesment.model.DataItem
import com.praneeth.assesment.model.remote.ApiResponse
import com.praneeth.assesment.model.remote.RetrofitBuilder

class Repository {


    val apiClient = RetrofitBuilder.getInstance().create(ApiResponse::class.java)
    val responseHandler = RetrofitNetworkRequestHandler.ResponseHandler()


    suspend fun getApiData(): RetrofitNetworkRequestHandler.Resource<DataItem?> {


        val response = apiClient.getResponse().data?.get(0)
        Log.d("TAG", response.toString())
        return try {
            responseHandler.handleSuccess(response!!)
        } catch (e: Exception) {

            responseHandler.handleException(e)
        }

    }



    // function declaration
    fun mul(a: Int, b: Int): Int{
        return a*b
    }
    //higher-order function declaration
    fun higherfunc() : ((Int,Int)-> Int){
        return ::mul
    }
    fun main(args: Array<String>) {
        // invoke function and store the returned function into a variable
        val multiply = higherfunc()
        // invokes the mul() function by passing arguments
        val result = multiply(2,4)
        println("The multiplication of two numbers is: $result")
    }



}