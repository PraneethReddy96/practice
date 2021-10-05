package com.praneeth.domain.interactor


import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.model.MainBalanceResponse
import com.praneeth.domain.repository.TransactionsRepository
import io.reactivex.Observable

import javax.inject.Inject

class GetMainBalanceUseCase @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val transactionsRepository: TransactionsRepository
) : ObservableUseCase<MainBalanceResponse, GetMainBalanceUseCase.Params>(threadExecutor,
    postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<MainBalanceResponse> {
        return transactionsRepository.getMainBalance()
    }

    data class Params(
        val mainBalanceResponse: MainBalanceResponse,
    )
}
