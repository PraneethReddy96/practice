package com.praneeth.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.praneeth.domain.transactionsEntity

@Database(entities =[transactionsEntity::class],version=2,exportSchema = false)
abstract class TransactionsDatabase : RoomDatabase() {

    abstract fun transactionsDao(): TransactionsDao
}