package com.praneeth.domain.repository
import com.praneeth.domain.model.TransactionsModel
import io.reactivex.Observable

interface TransactionsRepository {
    fun credit(title : String,transactionAmount :Double,type :String)
    fun debit(title : String, transactionAmount :Double,type :String)
    fun getMainBalance(): Double?
    fun getTransactions(): Observable<List<TransactionsModel>>
}