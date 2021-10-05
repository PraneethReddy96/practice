package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class DebitResponseBody(

    @field:SerializedName("amount")
    val amount: String? = null
)
