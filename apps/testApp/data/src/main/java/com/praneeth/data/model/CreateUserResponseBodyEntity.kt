package com.praneeth.data.model

import com.google.gson.annotations.SerializedName

data class CreateUserResponseBodyEntity(

    @field:SerializedName("user")
    val user: String?
)
