package com.praneeth.data.dataSource.transactions



import android.util.Log
import com.praneeth.data.cache.transactions.TransactionsCache
import com.praneeth.data.mapper.TransactionsEntityDataMapper
import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.data.model.MainBalanceResponseEntity
import com.praneeth.data.network.remote.TransactionsRemote
import com.praneeth.data.model.TransactionsEntity
import io.reactivex.Observable
import kotlinx.coroutines.*
import javax.inject.Inject

class TransactionsNetworkDataSource  @Inject constructor(private val transactionsRemote: TransactionsRemote,
                                                         private val transactionsCache: TransactionsCache,
                                                         private val transactionsEntityDataMapper: TransactionsEntityDataMapper
)
    : TransactionsDataSource {

    override fun credit(title: String,amount: Int, transactionAmount: Int, type: String):Observable<CreditResponseEntity> {
        var result = transactionsRemote.credit(transactionAmount.toString(), title)
        return result
    }

    override fun debit(title: String,amount: Int, transactionAmount: Int, type: String) :Observable<DebitResponseEntity>  {
        var result = transactionsRemote.debit(transactionAmount.toString(), title)
        return result
    }

    override fun getMainBalance(): Observable<MainBalanceResponseEntity>{

       var result= transactionsRemote.getMainBalance()

       return result
    }

    override fun getTransactions(): Observable<List<TransactionsEntity>> {

        var result = transactionsRemote.getTransactions().map {

            transactionsCache.deleteRedundantData()

            for(i in 0..it.size) {
              transactionsCache.saveTransactions(transactionsEntityDataMapper.mapEntityListTOCacheEntityList(
                  it).get(i))
          }
            return@map it
        }
        Log.d("result",result.toString())
        return result
    }
}


