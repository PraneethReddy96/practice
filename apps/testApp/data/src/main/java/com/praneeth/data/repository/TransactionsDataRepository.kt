package com.praneeth.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.praneeth.data.cache.preferences.PreferenceManager
import com.praneeth.data.dataSource.transactions.TransactionsDataSourceFactory
import com.praneeth.data.mapper.*
import com.praneeth.data.network.remote.TransactionsRemoteImpl
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import com.praneeth.domain.model.MainBalanceResponse
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable
import kotlinx.coroutines.*
import javax.inject.Inject

class TransactionsDataRepository @Inject constructor(
    private val transactionsDataSourceFactory: TransactionsDataSourceFactory,
    private val transactionsModelDataMapper: TransactionsModelDataMapper,
    private val transactionDetailsDataMapper: TransactionDetailsDataMapper,
    private val preferenceManager:PreferenceManager,
    private val mainBalanceDataMapper: MainBalanceDataMapper,
    private val creditDataMapper: CreditDataMapper,
    private val debitDataMapper: DebitDataMapper
) :
    TransactionsRepository {


    override fun credit(
        title: String,
        transactionAmount: Int,
        type: String,
    ): Observable<CreditResponse> {

//        transactionsDataSourceFactory.retrieveTransactionsNetworkDataSource()
//            .credit(title, transactionAmount,transactionAmount, "").map {
//
//                return@map creditDataMapper.mapEntityToModel(it)
//            }


        return transactionsDataSourceFactory.retrieveTransactionsCacheDataSource()
            .credit(title,transactionAmount, transactionAmount, type).map {
                return@map creditDataMapper.mapEntityToModel(it)
                   }


    }

    override fun debit(
        title: String,
        transactionAmount: Int,
        type: String,
    ): Observable<DebitResponse> {
              return  transactionsDataSourceFactory.retrieveTransactionsCacheDataSource()
            .debit(title,transactionAmount, transactionAmount, type).map {
                return@map debitDataMapper.mapEntityToModel(it)
                  }
//
//        return transactionsDataSourceFactory.retrieveTransactionsNetworkDataSource()
//            .debit(title, transactionAmount, transactionAmount,"").map {
//
//                return@map debitDataMapper.mapEntityToModel(it)
//            }
    }


    override fun getMainBalance(): Observable<MainBalanceResponse>{
        preferenceManager.setCurrentValue(System.currentTimeMillis())
        return transactionsDataSourceFactory.retrieveTransactionsDataSource().getMainBalance().map {
            return@map mainBalanceDataMapper.mapEntityToModel(it)
        }

//        return transactionsDataSourceFactory.retrieveTransactionsNetworkDataSource()
//            .getMainBalance().map {
//            return@map mainBalanceDataMapper.mapEntityToModel(it)
//        }
    }

    override fun getTransactions(): Observable<List<TransactionsModel>> {
        return transactionsDataSourceFactory.retrieveTransactionsDataSource().getTransactions()
           .map {
                return@map transactionDetailsDataMapper.mapEntityListToModelList(it)
           }

//        return transactionsDataSourceFactory.retrieveTransactionsNetworkDataSource()
//            .getTransactions()
//            .map {
//                Log.d("check6", it.toString())
//                return@map transactionDetailsDataMapper.mapEntityListToModelList(it)
//            }
    }

}












//
//
//CoroutineScope(Dispatchers.IO).launch {
//    transactionsDataSourceFactory.retrieveTransactionsCacheDataSource().credit("Debit",899000,  2000,"debit")
//}
