package com.praneeth.domain.interactor

import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.domain.transactionsEntity
import io.reactivex.Observable
import javax.inject.Inject

class GetTransactionsListUseCase @Inject constructor
    (private val TransactionsRepository: TransactionsRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
) : ObservableUseCase<List<transactionsEntity>, GetTransactionsListUseCase.Params>(threadExecutor,
    postExecutionThread) {


    override fun buildUseCaseObservable(params: Params): Observable<List<transactionsEntity>> {
        return TransactionsRepository.getTransactions()
    }

    data class Params(
        val transactionsEntity: List<transactionsEntity >
    )

}