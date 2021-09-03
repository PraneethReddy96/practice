package com.praneeth.data.cache.transactions

import androidx.room.Database
import androidx.room.RoomDatabase
import com.praneeth.data.entity.TransactionsEntity

@Database(entities =[TransactionsEntity::class],version=3,exportSchema = false)
abstract class TransactionsDatabase : RoomDatabase() {
    abstract fun transactionsDao(): TransactionsDao
}