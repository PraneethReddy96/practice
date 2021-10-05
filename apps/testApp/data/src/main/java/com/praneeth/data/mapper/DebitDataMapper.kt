package com.praneeth.data.mapper

import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import javax.inject.Inject

class DebitDataMapper @Inject constructor() {

    fun mapEntityToModel(debitResponseEntity: DebitResponseEntity) : DebitResponse {
        return DebitResponse(message = debitResponseEntity.message)
    }

    fun mapModelToEntity(debitResponse: DebitResponse) : DebitResponseEntity {
        return DebitResponseEntity(message = debitResponse.message)
    }

    fun mapCacheEToEntity(debitResponse: DebitResponse) : DebitResponseEntity {
        return DebitResponseEntity(message = debitResponse.message)
    }

}