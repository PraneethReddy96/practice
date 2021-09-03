package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsEntity
import com.praneeth.domain.model.TransactionsModel
import javax.inject.Inject

class TransactionDetailsDataMapper @Inject constructor() {

    private fun mapEntityToModel(transactionsEntity: TransactionsEntity): TransactionsModel {
        return TransactionsModel(
            time =transactionsEntity.time,
            title = transactionsEntity.title,
            amount = transactionsEntity.amount,
            transactionAmount = transactionsEntity.transactionAmount,
            type = transactionsEntity.type
        )
    }

   private fun mapModelToEntity(transactionsModel: TransactionsModel): TransactionsEntity {
        return TransactionsEntity(
            time =transactionsModel.time,
            title = transactionsModel.title,
            amount = transactionsModel.amount,
            transactionAmount = transactionsModel.transactionAmount,
            type = transactionsModel.type
        )
    }

    fun mapEntityListToModelList(transactionsEntity: List<TransactionsEntity>): List<TransactionsModel>{
        return transactionsEntity.map { entity ->
            mapEntityToModel(entity)
        }
    }

}