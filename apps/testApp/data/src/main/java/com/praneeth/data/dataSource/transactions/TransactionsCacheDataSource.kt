package com.praneeth.data.dataSource.transactions

import com.praneeth.data.Constants.zeroBalance
import com.praneeth.data.entity.TransactionsEntity
import com.praneeth.data.cache.transactions.TransactionsDao
import io.reactivex.Observable
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TransactionsCacheDataSource @Inject constructor(private val transactionsDao: TransactionsDao) :
    TransactionsDataSource {
    private val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    private val currentDate = sdf.format(Date())


    override fun credit(title: String, transactionAmount: Double, type: String) {

        CoroutineScope(Dispatchers.IO).launch {
            if (transactionsDao.checkData() == null) {

                transactionsDao.insertTransaction(TransactionsEntity(currentDate,
                    title,
                    transactionAmount,
                    transactionAmount,
                    type))
            } else {

                var finalAmount = transactionsDao.getLatestBalance().amount?.plus(transactionAmount)

                var transactionsEntity =
                    TransactionsEntity(currentDate,
                        title,
                        finalAmount,
                        transactionAmount,
                        type)
                transactionsDao.insertTransaction(transactionsEntity)

            }
        }
    }

    override fun debit(title: String, transactionAmount: Double, type: String) {
        CoroutineScope(Dispatchers.IO).launch {
            if (transactionsDao.checkData() == null) {

                transactionsDao.insertTransaction(TransactionsEntity(currentDate,
                    title,
                    -transactionAmount,
                    transactionAmount,
                    type))
            } else {

                var finalAmount =
                    transactionsDao.getLatestBalance().amount?.minus(transactionAmount)

                var transactionsEntity =
                    TransactionsEntity(currentDate,
                        title,
                        finalAmount,
                        transactionAmount,
                        type)

                transactionsDao.insertTransaction(transactionsEntity)
            }
        }
    }

    override fun getMainBalance(): Double? = runBlocking {
        withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            if (transactionsDao.checkData() != null) {
                transactionsDao.getLatestBalance().amount
            } else {
                zeroBalance
            }
        }
    }


    override fun getTransactions(): Observable<List<TransactionsEntity>> = runBlocking {
        withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            transactionsDao.getTransactions()
        }
    }

}