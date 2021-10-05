package com.praneeth.testapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.praneeth.domain.interactor.*
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import com.praneeth.domain.model.MainBalanceResponse
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.testapp.utils.Resource
import com.praneeth.testapp.utils.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getMainBalanceUseCase: GetMainBalanceUseCase,
    private val getTransactionsListUseCase: GetTransactionsListUseCase,
    private val creditUseCase: CreditUseCase,
    private val debitUseCase: DebitUseCase,

    ) : ViewModel() {

    var entityListLiveData: MutableLiveData<List<TransactionsModel>> = MutableLiveData()
    var mainBalanceLiveData:MutableLiveData<Resource<MainBalanceResponse>> = MutableLiveData()
    var creditLiveData:MutableLiveData<Resource<CreditResponse>> = MutableLiveData()
    var debitLiveData:MutableLiveData<Resource<DebitResponse>> = MutableLiveData()
    var transactionsModelList: List<TransactionsModel> = mutableListOf()
    var mainBalanceResponse : MainBalanceResponse = MainBalanceResponse(balance = null)



    fun credit(title: String, transactionAmount: Int, type: String) {
        creditLiveData.postValue(Resource(ResourceState.LOADING,null,null))
        creditUseCase.execute(object :DisposableObserver<CreditResponse>(){
            override fun onNext(t: CreditResponse) {
               creditLiveData.postValue(Resource(ResourceState.SUCCESS,t,null))
            }

            override fun onError(e: Throwable) {
                creditLiveData.postValue(Resource(ResourceState.ERROR,null,null))
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        },CreditUseCase.Params(title,transactionAmount,type))
    }

    fun debit(title: String, transactionAmount: Int, type: String) {
        debitLiveData.postValue(Resource(ResourceState.LOADING,null,null))
        debitUseCase.execute(object :DisposableObserver<DebitResponse>(){
            override fun onNext(t: DebitResponse) {
                debitLiveData.postValue(Resource(ResourceState.SUCCESS,t,null))
            }

            override fun onError(e: Throwable) {
                debitLiveData.postValue(Resource(ResourceState.ERROR,null,null))
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        },DebitUseCase.Params(title,transactionAmount,type))
    }

    fun getTransactions() {
        entityListLiveData.postValue(transactionsModelList)
        getTransactionsListUseCase.execute(object : DisposableObserver<List<TransactionsModel>>() {
            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: transaction error")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: completed")
            }

            override fun onNext(t: List<TransactionsModel>) {
                Log.d(TAG, t.get(0).toString())
                entityListLiveData.postValue(t)
            }
        }, GetTransactionsListUseCase.Params(transactionsModelList))
    }

    fun getMainBalance() {
        mainBalanceLiveData.postValue(Resource(ResourceState.LOADING,null,null))
        getMainBalanceUseCase.execute(object:DisposableObserver<MainBalanceResponse>(){
            override fun onNext(t: MainBalanceResponse) {
                mainBalanceLiveData.postValue(Resource(ResourceState.SUCCESS,t,null))
            }

            override fun onError(e: Throwable) {
                mainBalanceLiveData.postValue(Resource(ResourceState.ERROR,null,null))
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        },GetMainBalanceUseCase.Params(mainBalanceResponse))
    }

}



