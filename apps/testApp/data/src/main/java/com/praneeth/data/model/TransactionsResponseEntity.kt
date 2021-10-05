package com.praneeth.data.model

import com.google.gson.annotations.SerializedName

data class TransactionsResponseEntity(

    @field:SerializedName("transactions")
    val transactions: List<TransactionsEntity>
)

data class TransactionsEntity(

    @field:SerializedName("amount")
    val amount: Int? ,

    @field:SerializedName("transactionAmount")
    val transactionAmount: Int? ,

    @field:SerializedName("time")
    val time: String? ,

    @field:SerializedName("_id")
    val id: String? ,

    @field:SerializedName("type")
    val type: String?,

    @field:SerializedName("title")
    val title: String?
)
