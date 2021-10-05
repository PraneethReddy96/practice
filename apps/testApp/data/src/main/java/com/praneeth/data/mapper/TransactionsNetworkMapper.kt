package com.praneeth.data.mapper


import com.praneeth.data.model.TransactionsEntity
import com.praneeth.domain.model.TransactionsModel
import javax.inject.Inject

class TransactionDetailsDataMapper @Inject constructor() {

    private fun mapEntityToModel(transactionsEntity: TransactionsEntity): TransactionsModel {
        return TransactionsModel(amount = transactionsEntity.amount,
            transactionAmount = transactionsEntity.transactionAmount,
            time = transactionsEntity.time,
            id = transactionsEntity.id,
            title = transactionsEntity.title,
            type = transactionsEntity.type)
    }

    private fun mapModelToEntity(transactionsModel: TransactionsModel): TransactionsEntity {
        return TransactionsEntity(amount = transactionsModel.amount,
            transactionAmount = transactionsModel.transactionAmount,
            time = transactionsModel.time,
            id = transactionsModel.id,
            title = transactionsModel.title,
            type = transactionsModel.type)
    }


    fun mapEntityListToModelList(transactionsEntity: List<TransactionsEntity>): List<TransactionsModel> {
        return transactionsEntity.map { entity ->
            mapEntityToModel(entity)
        }
    }


}