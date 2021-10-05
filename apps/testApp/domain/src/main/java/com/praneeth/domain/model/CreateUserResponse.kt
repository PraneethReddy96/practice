package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class CreateUserResponse(

    @field:SerializedName("message")
    val message: String? = null
)
