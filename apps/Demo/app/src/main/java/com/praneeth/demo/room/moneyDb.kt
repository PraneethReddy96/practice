package com.praneeth.demo.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[transactionsEntity::class],version=1,exportSchema = false)
abstract class moneyDb : RoomDatabase() {

    abstract fun moneyDao(): moneyDao
}