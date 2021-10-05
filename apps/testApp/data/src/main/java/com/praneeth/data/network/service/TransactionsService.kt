package com.praneeth.data.network.service

import com.praneeth.data.model.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface TransactionsService {

    @GET("/api/transactions")
    fun getTransactions() : Observable<Response<TransactionsResponseEntity>>

    @GET("/api/balance")
     fun getBalance() : Observable<Response<MainBalanceResponseEntity>>


    @POST("/api/credit")
     fun credit(@Body creditResponseBody: CreditResponseBody) :Observable<Response<CreditResponseEntity>>

    @POST("/api/debit")
     fun debit(@Body debitResponseBody: DebitResponseBody) : Observable<Response<DebitResponseEntity>>

    @POST("/api/transactions")
    fun createUser(@Body CreateUserResponseBody: CreateUserResponseBodyEntity) : Observable<Response<CreateUserResponseEntity>>

}