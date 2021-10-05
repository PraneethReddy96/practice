package com.praneeth.data.mapper

import com.praneeth.data.entity.TransactionsCacheEntity
import com.praneeth.data.model.CreditResponseEntity
import javax.inject.Inject

class CreditResponseEntityMapper @Inject constructor() {

  fun  mapCacheEntityToCreditResponseEntity( transactinsCacheEntity :TransactionsCacheEntity) : CreditResponseEntity {
        return CreditResponseEntity(message = transactinsCacheEntity.type)
  }
}