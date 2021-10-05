package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsCacheEntity
import com.praneeth.domain.model.TransactionsModel
import javax.inject.Inject

class TransactionsModelDataMapper @Inject constructor() {

    private fun mapEntityToModel(transactionsCacheEntity: TransactionsCacheEntity): TransactionsModel {
        return TransactionsModel(
            time = transactionsCacheEntity.time,
            title = transactionsCacheEntity.title,
            amount = transactionsCacheEntity.amount,
            transactionAmount = transactionsCacheEntity.transactionAmount,
            type = transactionsCacheEntity.type,
            id = transactionsCacheEntity.id

        )
    }

    private fun mapModelToEntity(transactionsModel: TransactionsModel): TransactionsCacheEntity {
        return TransactionsCacheEntity(
            time = transactionsModel.time,
            title = transactionsModel.title,
            amount = transactionsModel.amount,
            transactionAmount = transactionsModel.transactionAmount,
            type = transactionsModel.type,
            id = transactionsModel.id
        )
    }


    fun mapEntityListToModelList(transactionsCacheEntity: List<TransactionsCacheEntity>): List<TransactionsModel> {
        return transactionsCacheEntity.map { entity ->
            mapEntityToModel(entity)
        }
    }

}