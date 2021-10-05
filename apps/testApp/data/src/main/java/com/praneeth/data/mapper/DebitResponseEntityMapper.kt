package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsCacheEntity
import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import javax.inject.Inject

class DebitResponseEntityMapper @Inject constructor() {

    fun  mapCacheEntityToDebitResponseEntity( transactinsCacheEntity : TransactionsCacheEntity) : DebitResponseEntity {
        return DebitResponseEntity(message = transactinsCacheEntity.type)
    }
}