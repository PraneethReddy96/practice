package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class DebitResponse(

    @field:SerializedName("message")
    val message: String? = null
)
