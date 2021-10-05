package com.praneeth.data.cache.transactions

import com.praneeth.data.cache.dao.TransactionsDao
import com.praneeth.data.entity.TransactionsCacheEntity
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TransactionsCacheImpl @Inject constructor(private val transactionsDao: TransactionsDao): TransactionsCache{
    private val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    private val currentDate = sdf.format(Date())

//    override fun credit(title: String,
//                        amount: Int,
//                        transactionAmount: Int,
//                        type: String): Observable<TransactionsCacheEntity> {
//
//
//                var transactionsEntity =
//                    TransactionsCacheEntity(currentDate,
//                        title,
//                        amount,
//                        transactionAmount,
//                        type,id = null)
//                transactionsDao.insertTransaction(transactionsEntity)
//
//        return transactionsDao.getLatestBalance()
//
//    }
//
//
//
//    override fun debit(title: String,
//                       amount: Int,
//                       transactionAmount: Int,
//                       type: String): Observable<TransactionsCacheEntity> {
//
//        var transactionsEntity =
//            TransactionsCacheEntity(currentDate,
//                title,
//                amount,
//                transactionAmount,
//                type,id = null)
//        transactionsDao.insertTransaction(transactionsEntity)
//
//        return transactionsDao.getLatestBalance()
//    }


    override fun getMainBalance(): Observable<TransactionsCacheEntity> {

        return transactionsDao.getLatestBalance()
    }

    override fun getTransactions(): Observable<List<TransactionsCacheEntity>> {
        return transactionsDao.getTransactions()
    }

    override fun saveTransactions(transactionsCacheEntity: TransactionsCacheEntity) {
        transactionsDao.saveTransactions(transactionsCacheEntity)
    }

    override fun deleteRedundantData() {
        transactionsDao.delete()
    }


}