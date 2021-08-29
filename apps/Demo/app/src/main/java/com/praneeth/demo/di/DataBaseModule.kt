package com.praneeth.demo.di

import android.content.Context
import androidx.room.Room
import com.praneeth.demo.room.moneyDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): moneyDb = Room.databaseBuilder(
        context,
        moneyDb::class.java,
        "Money_Manager"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: moneyDb) = database.moneyDao()


}