package com.praneeth.domain.interactor


import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.model.DebitResponse
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable
import javax.inject.Inject

class DebitUseCase
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val transactionsRepository: TransactionsRepository
):ObservableUseCase<DebitResponse,DebitUseCase.Params>(threadExecutor,postExecutionThread) {

    data class Params(
       val title: String,
       val transactionAmount: Int,
       val type: String
    )

    override fun buildUseCaseObservable(params: Params): Observable<DebitResponse> {
        return transactionsRepository.debit(params.title,params.transactionAmount,params.type)
    }

}