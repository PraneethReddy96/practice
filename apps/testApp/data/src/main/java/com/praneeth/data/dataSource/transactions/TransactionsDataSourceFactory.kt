package com.praneeth.data.dataSource.transactions

import android.util.Log
import com.praneeth.data.cache.preferences.PreferenceManager
import com.praneeth.data.cache.transactions.TransactionsCacheImpl
import com.praneeth.data.network.remote.TransactionsRemoteImpl
import javax.inject.Inject

class TransactionsDataSourceFactory @Inject constructor(
    private val transactionsNetworkDataSource: TransactionsNetworkDataSource,
    private val transactionsCacheDataSource: TransactionsCacheDataSource,
    private val preferenceManager: PreferenceManager
) {


    fun retrieveTransactionsDataSource(): TransactionsDataSource{

        if(preferenceManager.userCurrentActivityState >= 20000 || preferenceManager.currentTime==0L){
            Log.d("time567", preferenceManager.currentTime.toString())
            Log.d("time5678", preferenceManager.startTime.toString())
            return retrieveTransactionsNetworkDataSource()
        }else
            return retrieveTransactionsCacheDataSource()
    }

    fun retrieveTransactionsCacheDataSource(): TransactionsCacheDataSource {
            return transactionsCacheDataSource

    }


    fun retrieveTransactionsNetworkDataSource(): TransactionsNetworkDataSource {
        return transactionsNetworkDataSource
    }

}