package com.praneeth.data.model

import com.google.gson.annotations.SerializedName

data class CreditResponseBody(

    @field:SerializedName("amount")
    val amount: String? ,


    @field:SerializedName("title")
    val title: String?

    )
