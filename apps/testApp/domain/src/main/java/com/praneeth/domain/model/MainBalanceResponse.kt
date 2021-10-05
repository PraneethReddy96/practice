package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class MainBalanceResponse(

    @field:SerializedName("balance")
    val balance: Int? = null
)
