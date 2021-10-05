package com.praneeth.domain.interactor

import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable
import javax.inject.Inject

class CreditUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
):ObservableUseCase<CreditResponse,CreditUseCase.Params>(threadExecutor,postExecutionThread){

    data class Params(
        val title: String,
        val transactionAmount: Int,
        val type: String
    )

    override fun buildUseCaseObservable(params: Params): Observable<CreditResponse> {
        return transactionsRepository.credit(params.title,params.transactionAmount,params.type)
    }


}