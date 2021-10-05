package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class CreditResponseBody(

    @field:SerializedName("amount")
    val amount: String? = null
)
