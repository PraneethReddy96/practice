package com.praneeth.data.network.interceptor

import com.praneeth.data.Constants
import okhttp3.Interceptor
import okhttp3.Response

class TransactionsNetworkInterceptor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Accept", Constants.Accept)
            .addHeader("Content-Type",Constants.ContentType)
            .addHeader("Authorization",Constants.Authorization)
            .build()
        return chain.proceed(request)
    }
}