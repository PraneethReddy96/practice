package com.praneeth.domain.interactor

import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.domain.transactionsEntity
import io.reactivex.Observable
import javax.inject.Inject

class CreditUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
) {

    fun credit(title: String, transactionAmount: Double, type: String) {
        transactionsRepository.credit(title, transactionAmount, type)
    }

}