package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

data class CreateUserResponseBody(

    @field:SerializedName("user")
    val user: String? = null
)
