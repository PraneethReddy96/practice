package com.praneeth.data.mapper

import com.praneeth.data.model.CreditResponseEntity
import com.praneeth.data.model.DebitResponseEntity
import com.praneeth.domain.model.CreditResponse
import com.praneeth.domain.model.DebitResponse
import javax.inject.Inject

class CreditDataMapper @Inject constructor() {

    fun mapEntityToModel(creditResponseEntity: CreditResponseEntity) : CreditResponse{
        return CreditResponse(message = creditResponseEntity.message)
    }

    fun mapModelToEntity(creditResponse: CreditResponse) : CreditResponseEntity {
        return CreditResponseEntity(message = creditResponse.message)
    }


}