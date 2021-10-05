package com.praneeth.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.praneeth.data.cache.dao.TransactionsDao
import com.praneeth.data.entity.TransactionsCacheEntity

@Database(entities =[TransactionsCacheEntity::class],version=4,exportSchema = false)
abstract class TransactionsDatabase : RoomDatabase() {
    abstract fun transactionsDao(): TransactionsDao
}