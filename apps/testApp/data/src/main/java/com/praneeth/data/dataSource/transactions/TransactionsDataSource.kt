package com.praneeth.data.dataSource.transactions

import com.praneeth.data.entity.TransactionsEntity
import io.reactivex.Observable

interface TransactionsDataSource {
    fun credit(title : String,transactionAmount :Double,type :String)
    fun debit(title : String, transactionAmount :Double,type :String)
    fun getMainBalance(): Double?
    fun getTransactions(): Observable<List<TransactionsEntity>>
}