package com.praneeth.demo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class transactionsEntity(@ColumnInfo(name = "Time") var time: String?,
                         @ColumnInfo(name = "Title") var title: String?,
                         @ColumnInfo(name = "Amount") var amount: Float?,
                         @ColumnInfo(name = "TransactionAmount") var transactionAmount: Float?,
                         @ColumnInfo(name = "Type") var type: String?,
                         @ColumnInfo(name = "Color") var color: String?) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

}