package com.praneeth.data.cache.transactions

import com.praneeth.data.entity.TransactionsCacheEntity
import io.reactivex.Observable


interface TransactionsCache {

//    fun credit(title: String,
//               amount:Int,
//               transactionAmount: Int,
//               type: String): Observable<TransactionsCacheEntity>
//    fun debit(title: String,
//              amount:Int,
//              transactionAmount: Int,
//              type: String):Observable<TransactionsCacheEntity>
    fun getMainBalance():Observable<TransactionsCacheEntity>
    fun getTransactions():Observable<List<TransactionsCacheEntity>>
    fun saveTransactions(transactionsCacheEntity: TransactionsCacheEntity)
    fun deleteRedundantData()
}