package com.praneeth.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Transactions")
class TransactionsCacheEntity(
    @ColumnInfo(name = "Time") var time: String?,
    @ColumnInfo(name = "Title") var title: String?,
    @ColumnInfo(name = "Amount") var amount: Int?,
    @ColumnInfo(name = "TransactionAmount") var transactionAmount: Int?,
    @ColumnInfo(name = "Type") var type: String?,
    @ColumnInfo(name = "Id") var id: String?,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Number")
    var number: Int? = null

}