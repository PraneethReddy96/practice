package com.praneeth.data.dataSource.transactions

import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.data.model.MainBalanceResponseEntity
import com.praneeth.data.model.TransactionsEntity
import io.reactivex.Observable

interface TransactionsDataSource {
    fun credit(
        title: String,
        amount:Int,
        transactionAmount: Int,
        type: String,
    ): Observable<CreditResponseEntity>

    fun debit(
        title: String,
        amount: Int,
        transactionAmount: Int,
        type: String,
    ): Observable<DebitResponseEntity>

    fun getMainBalance(): Observable<MainBalanceResponseEntity>
    fun getTransactions(): Observable<List<TransactionsEntity>>

}