package com.praneeth.data.dataSource.transactions

import javax.inject.Inject

class TransactionsDataSourceFactory @Inject constructor(
    private val transactionsDataSource: TransactionsCacheDataSource)
    {
    fun retrieveTransactionsCacheDataSource() : TransactionsCacheDataSource{
        return transactionsDataSource
    }
}