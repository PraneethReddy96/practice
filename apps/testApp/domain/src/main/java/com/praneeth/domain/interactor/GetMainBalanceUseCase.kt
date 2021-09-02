package com.praneeth.domain.interactor


import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.domain.transactionsEntity
import io.reactivex.Observable

import javax.inject.Inject

class GetMainBalanceUseCase @Inject constructor (
    private val TransactionsRepository: TransactionsRepository,
){
    fun getMainBalance():Double?{
        return TransactionsRepository.getMainBalance()
    }
}
