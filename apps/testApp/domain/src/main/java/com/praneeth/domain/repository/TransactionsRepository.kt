package com.praneeth.domain.repository


import com.praneeth.domain.transactionsEntity
import io.reactivex.Observable


interface TransactionsRepository {

    fun insertValues(title : String, amount: Double, transactionAmount :Double,type :String):Observable<List<transactionsEntity>>

    fun credit(title : String,transactionAmount :Double,type :String)

    fun debit(title : String, transactionAmount :Double,type :String)

    fun getMainBalance(): Double?

    fun getTransactions(): Observable<List<transactionsEntity>>


}