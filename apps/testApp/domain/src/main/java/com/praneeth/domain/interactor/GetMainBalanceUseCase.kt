package com.praneeth.domain.interactor


import com.praneeth.domain.repository.TransactionsRepository

import javax.inject.Inject

class GetMainBalanceUseCase @Inject constructor (
    private val TransactionsRepository: TransactionsRepository,
){
    fun getMainBalance():Double?{
        return TransactionsRepository.getMainBalance()
    }
}
