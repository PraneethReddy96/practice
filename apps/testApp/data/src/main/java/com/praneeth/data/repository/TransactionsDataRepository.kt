package com.praneeth.data.repository

import com.praneeth.data.mapper.TransactionDetailsDataMapper
import com.praneeth.data.dataSource.transactions.TransactionsDataSourceFactory
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable
import javax.inject.Inject

class TransactionsDataRepository @Inject constructor(
    private val transactionsDataSourceFactory: TransactionsDataSourceFactory,
    private val transactionDetailsDataMapper: TransactionDetailsDataMapper,
) :
    TransactionsRepository {

    override fun credit(title: String, transactionAmount: Double, type: String) {
        transactionsDataSourceFactory.retrieveTransactionsCacheDataSource()
            .credit(title, transactionAmount, type)
    }

    override fun debit(title: String, transactionAmount: Double, type: String) {
        transactionsDataSourceFactory.retrieveTransactionsCacheDataSource()
            .debit(title, transactionAmount, type)
    }

    override fun getMainBalance(): Double? {
        return transactionsDataSourceFactory.retrieveTransactionsCacheDataSource().getMainBalance()
    }

    override fun getTransactions(): Observable<List<TransactionsModel>> {
        return transactionsDataSourceFactory.retrieveTransactionsCacheDataSource().getTransactions()
            .map {
                return@map transactionDetailsDataMapper.mapEntityListToModelList(it)
            }
    }
}
