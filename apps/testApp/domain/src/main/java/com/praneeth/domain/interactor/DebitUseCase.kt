package com.praneeth.domain.interactor


import com.praneeth.domain.repository.TransactionsRepository
import javax.inject.Inject

class DebitUseCase
@Inject constructor(
    private val transactionsRepository: TransactionsRepository
) {


    fun debit(title: String, transactionAmount: Double, type: String) {
        transactionsRepository.debit(title, transactionAmount, type)
    }

}