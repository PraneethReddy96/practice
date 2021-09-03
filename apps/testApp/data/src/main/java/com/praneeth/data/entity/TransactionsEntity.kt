package com.praneeth.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Transactions")
class TransactionsEntity(@ColumnInfo(name = "Time") var time: String?,
                         @ColumnInfo(name = "Title") var title: String?,
                         @ColumnInfo(name = "Amount") var amount: Double?,
                         @ColumnInfo(name = "TransactionAmount") var transactionAmount: Double?,
                         @ColumnInfo(name = "Type") var type: String?){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

}