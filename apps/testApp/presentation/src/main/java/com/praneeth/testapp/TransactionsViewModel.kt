package com.praneeth.testapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.praneeth.domain.interactor.CreditUseCase
import com.praneeth.domain.interactor.DebitUseCase
import com.praneeth.domain.interactor.GetMainBalanceUseCase
import com.praneeth.domain.interactor.GetTransactionsListUseCase
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.domain.transactionsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
    private val getMainBalanceUseCase: GetMainBalanceUseCase,
    private val getTransactionsListUseCase: GetTransactionsListUseCase,
    private val creditUseCase: CreditUseCase,
    private val debitUseCase: DebitUseCase

    ) : ViewModel() {

    var entityLiveData: MutableLiveData<transactionsEntity> = MutableLiveData()
    var entityListLiveData: MutableLiveData<List<transactionsEntity>> = MutableLiveData()
    var transactionsEntityList: List<transactionsEntity> = mutableListOf()



    fun credit(title: String, transactionAmount: Double, type: String) {
        creditUseCase.credit(title, transactionAmount, type)
    }

    fun debit(title: String, transactionAmount: Double, type: String) {
        debitUseCase.debit(title, transactionAmount, type)
    }

    fun getTransactions() {
        entityListLiveData.postValue(transactionsEntityList)
        getTransactionsListUseCase.execute(object : DisposableObserver<List<transactionsEntity>>() {


            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: transaction error")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: completed")
            }

            override fun onNext(t: List<transactionsEntity>) {
                entityListLiveData.postValue(t)
            }
        }, GetTransactionsListUseCase.Params(transactionsEntityList))
    }


    fun getMainBalance(): Double?{
        return getMainBalanceUseCase.getMainBalance()
    }

}



