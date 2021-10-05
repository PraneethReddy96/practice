package com.praneeth.domain.repository
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import com.praneeth.domain.model.MainBalanceResponse
import com.praneeth.domain.model.TransactionsModel
import io.reactivex.Observable

interface TransactionsRepository {
    fun credit(title : String,transactionAmount :Int,type :String):Observable<CreditResponse>
    fun debit(title : String, transactionAmount :Int,type :String):Observable<DebitResponse>
    fun getMainBalance(): Observable<MainBalanceResponse>
    fun getTransactions(): Observable<List<TransactionsModel>>
}