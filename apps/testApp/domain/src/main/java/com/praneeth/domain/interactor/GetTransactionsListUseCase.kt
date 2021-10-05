package com.praneeth.domain.interactor

import android.util.Log
import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.domain.model.TransactionsModel
import io.reactivex.Observable
import javax.inject.Inject

class GetTransactionsListUseCase @Inject constructor
    (private val transactionsRepository: TransactionsRepository,
     threadExecutor: ThreadExecutor,
     postExecutionThread: PostExecutionThread,
) : ObservableUseCase<List<TransactionsModel>, GetTransactionsListUseCase.Params>(threadExecutor,
    postExecutionThread) {


    override fun buildUseCaseObservable(params: Params): Observable<List<TransactionsModel>> {
        var result = transactionsRepository.getTransactions().map {

            Log.d("check8", it.toString())
            return@map it
        }.map {
            Log.d("check9", it.toString())
            return@map it
        }
        Log.d("check10", result.toString())
        return result
    }

    data class Params(
        val TransactionsModel: List<TransactionsModel>
    )

}