package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsCacheEntity
import com.praneeth.data.model.MainBalanceResponseEntity
import com.praneeth.data.model.TransactionsEntity
import com.praneeth.domain.model.MainBalanceResponse
import com.praneeth.domain.model.TransactionsModel
import javax.inject.Inject

class MainBalanceDataMapper @Inject constructor() {

    fun mapEntityToModel(mainBalanceResponseEntity: MainBalanceResponseEntity): MainBalanceResponse {
        return MainBalanceResponse(balance = mainBalanceResponseEntity.balance)
    }

     fun mapEntityToModel(mainBalanceResponse: MainBalanceResponse): MainBalanceResponseEntity {
        return MainBalanceResponseEntity(balance = mainBalanceResponse.balance)
    }

    fun mapCacheEntityToEntity(transactionsCacheEntity: TransactionsCacheEntity) :MainBalanceResponseEntity{
        return MainBalanceResponseEntity(balance = transactionsCacheEntity.amount)
    }

    fun mapEntityListToModelList(mainBalanceResponseEntity: List<MainBalanceResponseEntity>): List<MainBalanceResponse> {
        return mainBalanceResponseEntity.map { entity ->
            mapEntityToModel(entity)
        }
    }

}