package com.praneeth.domain.model

import com.google.gson.annotations.SerializedName

class TransactionsModel(
    val amount: Int?,
    val transactionAmount: Int?,
    val time: String?,
    val id: String?,
    val type: String?,
    val title: String?,
)