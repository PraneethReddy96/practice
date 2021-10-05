package com.praneeth.data.dataSource.transactions

import com.praneeth.data.cache.dao.TransactionsDao
import com.praneeth.data.cache.transactions.TransactionsCache
import com.praneeth.data.mapper.CreditResponseEntityMapper
import com.praneeth.data.mapper.DebitResponseEntityMapper
import com.praneeth.data.mapper.MainBalanceDataMapper
import com.praneeth.data.mapper.TransactionsEntityDataMapper
import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.data.model.MainBalanceResponseEntity
import com.praneeth.data.model.TransactionsEntity
import io.reactivex.Observable
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TransactionsCacheDataSource @Inject constructor(
    private val transactionsCache: TransactionsCache,
    private val creditResponseEntityMapper: CreditResponseEntityMapper,
    private val debitResponseEntityMapper: DebitResponseEntityMapper,
    private val transactionsEntityDataMapper: TransactionsEntityDataMapper,
    private val mainBalanceDataMapper: MainBalanceDataMapper
) :
    TransactionsDataSource {

    override fun credit(
        title: String,
        amount: Int,
        transactionAmount: Int,
        type: String,
    ): Observable<CreditResponseEntity> {
       TODO()
    }

    override fun debit(
        title: String,
        amount: Int,
        transactionAmount: Int,
        type: String,
    ): Observable<DebitResponseEntity> {
       TODO()
    }

    override fun getMainBalance(): Observable<MainBalanceResponseEntity> {
        return transactionsCache.getMainBalance().map {
            return@map mainBalanceDataMapper.mapCacheEntityToEntity(it)//
        }
    }

    override fun getTransactions(): Observable<List<TransactionsEntity>> {
        return transactionsCache.getTransactions().map {
            return@map transactionsEntityDataMapper.mapCacheEntityListToEntityList(it)
        }
    }

//
//    override fun credit(title: String, transactionAmount: Int, type: String) :String?{
//
//        CoroutineScope(Dispatchers.IO).launch {
//            if (transactionsDao.checkData() == null) {
//
//                transactionsDao.insertTransaction(TransactionsCacheEntity(currentDate,
//                    title,
//                    transactionAmount,
//                    transactionAmount,
//                    type))
//            } else {
//
//                var finalAmount = transactionsDao.getLatestBalance().amount?.plus(transactionAmount)
//
//                var transactionsEntity =
//                    TransactionsCacheEntity(currentDate,
//                        title,
//                        finalAmount,
//                        transactionAmount,
//                        type)
//                transactionsDao.insertTransaction(transactionsEntity)
//
//            }
//        }
//        return credited
//    }
//
//    override fun debit(title: String, transactionAmount: Int, type: String) :Observable<DebitResponseEntity> {
////        CoroutineScope(Dispatchers.IO).launch {
////            if (transactionsDao.checkData() == null) {
////
////                transactionsDao.insertTransaction(TransactionsCacheEntity(currentDate,
////                    title,
////                    -transactionAmount,
////                    transactionAmount,
////                    type))
////            } else {
////
////                var finalAmount =
////                    transactionsDao.getLatestBalance().amount?.minus(transactionAmount)
////
////                var transactionsEntity =
////                    TransactionsCacheEntity(currentDate,
////                        title,
////                        finalAmount,
////                        transactionAmount,
////                        type)
////
////                transactionsDao.insertTransaction(transactionsEntity)
////            }
//        TODO()
//        }
//
//    }
//
//     fun getMainBalance() :Int = runBlocking  {
//        withContext(CoroutineScope(Dispatchers.).coroutineContext) {
//
//        }
//        TODO()
//    }

}