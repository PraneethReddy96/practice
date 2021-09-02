package com.praneeth.data


import android.util.Log
import com.praneeth.data.room.TransactionsDao
import com.praneeth.domain.transactionsEntity
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TransactionsDataRepository @Inject constructor(val TransactionsDao: TransactionsDao) :
    TransactionsRepository {
    override fun insertValues(
        title: String,
        amount: Double,
        transactionAmount: Double,
        type: String,
    ): Observable<List<transactionsEntity>> {
        TODO("Not yet implemented")
    }


    override fun credit(title: String, transactionAmount: Double, type: String) {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        CoroutineScope(Dispatchers.IO).launch {
            if (TransactionsDao.checkData() == null) {

                TransactionsDao.insertTransaction(transactionsEntity(currentDate,
                    title,
                    transactionAmount,
                    transactionAmount,
                    type))
            } else {

                var finalAmount: Double? = null

                finalAmount = TransactionsDao.getLatestBalance().amount?.plus(transactionAmount)
                Log.d("crdited amount", finalAmount.toString())

                var transactionsEntity =
                    transactionsEntity(currentDate,
                        title,
                        finalAmount,
                        transactionAmount,
                        type)
                TransactionsDao.insertTransaction(transactionsEntity)

            }
        }
    }

    override fun debit(title: String, transactionAmount: Double, type: String) {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        CoroutineScope(Dispatchers.IO).launch {
            if (TransactionsDao.checkData() == null) {

                TransactionsDao.insertTransaction(transactionsEntity(currentDate,
                    title,
                    -transactionAmount,
                    transactionAmount,
                    type))
            } else {

                var finalAmount: Double? = null

                finalAmount = TransactionsDao.getLatestBalance().amount?.minus(transactionAmount)

                Log.d("amount", finalAmount.toString())
                var transactionsEntity =
                    transactionsEntity(currentDate,
                        title,
                        finalAmount,
                        transactionAmount,
                        type)
                TransactionsDao.insertTransaction(transactionsEntity)
            }
        }
    }

    override fun getMainBalance(): Double? = runBlocking {

        CoroutineScope(Dispatchers.IO).async {
                if(TransactionsDao.checkData() != null) {
                    TransactionsDao.getLatestBalance().amount
                }else{
                    0.0
                }
            }.await()
    }


    override fun getTransactions(): Observable<List<transactionsEntity>> = runBlocking {
        CoroutineScope(Dispatchers.IO).async {
            TransactionsDao.getTransactions()
        }.await()
    }
}
