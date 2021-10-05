package com.praneeth.data.model

import com.google.gson.annotations.SerializedName

data class MainBalanceResponseEntity(

    @field:SerializedName("balance")
    val balance: Int?
)
