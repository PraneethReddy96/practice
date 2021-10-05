package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsCacheEntity
import com.praneeth.data.model.TransactionsEntity
import com.praneeth.domain.model.TransactionsModel
import javax.inject.Inject

class TransactionsEntityDataMapper @Inject constructor() {
    private fun mapCacheEntityToEntity(transactionsCacheEntity: TransactionsCacheEntity): TransactionsEntity {
        return TransactionsEntity(
            time = transactionsCacheEntity.time,
            title = transactionsCacheEntity.title,
            amount = transactionsCacheEntity.amount,
            transactionAmount = transactionsCacheEntity.transactionAmount,
            type = transactionsCacheEntity.type,
            id = transactionsCacheEntity.id

        )
    }

    private fun mapEntityToCacheEntity(transactionsEntity: TransactionsEntity): TransactionsCacheEntity {
        return TransactionsCacheEntity(
            time = transactionsEntity.time,
            title = transactionsEntity.title,
            amount = transactionsEntity.amount,
            transactionAmount = transactionsEntity.transactionAmount,
            type = transactionsEntity.type,
            id = transactionsEntity.id
        )
    }


    fun mapCacheEntityListToEntityList(transactionsCacheEntity: List<TransactionsCacheEntity>): List<TransactionsEntity> {
        return transactionsCacheEntity.map { entity ->
            mapCacheEntityToEntity(entity)
        }
    }

    fun mapEntityListTOCacheEntityList(transactionsEntity: List< TransactionsEntity>): List<TransactionsCacheEntity>{

        return transactionsEntity.map { entity->
            mapEntityToCacheEntity(entity)
        }
    }

}