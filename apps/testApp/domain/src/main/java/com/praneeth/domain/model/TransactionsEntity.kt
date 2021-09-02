package com.praneeth.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Transactions")
class transactionsEntity(@ColumnInfo(name = "Time") var time: String?,
                         @ColumnInfo(name = "Title") var title: String?,
                         @ColumnInfo(name = "Amount") var amount: Double? = 0.0,
                         @ColumnInfo(name = "TransactionAmount") var transactionAmount: Double?,
                         @ColumnInfo(name = "Type") var type: String?){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

}