package com.praneeth.assesment.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    fun <S> createService(serviceClass: Class<S>?): S {
        val retrofit: Retrofit = getInstance()
        return retrofit.create(serviceClass)
    }

    companion object {



        /* returns retrofit instance*/
        fun getInstance(): Retrofit {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://dummy.restapiexample.com")
                .addConverterFactory(GsonConverterFactory.create())

            return retrofitBuilder.build()
        }
    }
}