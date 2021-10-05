package com.praneeth.data.network.remote

import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.data.model.MainBalanceResponseEntity
import com.praneeth.data.model.TransactionsEntity
import io.reactivex.Observable

interface  TransactionsRemote {

    fun credit(amount:String, title:String):Observable<CreditResponseEntity>
    fun debit(amount:String,title:String): Observable<DebitResponseEntity>
    fun getMainBalance() : Observable<MainBalanceResponseEntity>
    fun getTransactions(): Observable<List<TransactionsEntity>>

}