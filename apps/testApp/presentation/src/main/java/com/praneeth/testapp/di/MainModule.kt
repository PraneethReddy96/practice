package com.praneeth.presentation.di

import android.content.Context
import androidx.room.Room
import com.praneeth.data.JobExecutor
import com.praneeth.data.TransactionsDataRepository
import com.praneeth.data.room.TransactionsDao
import com.praneeth.data.room.TransactionsDatabase
import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.testapp.utils.UIThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TransactionsDatabase = Room.databaseBuilder(
        context,
        TransactionsDatabase::class.java,
        "Money_Manager"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: TransactionsDatabase) = database.transactionsDao()

    @Singleton
    @Provides
    fun provideMainRepository(dao: TransactionsDao): TransactionsRepository = TransactionsDataRepository(dao)

    @JvmStatic
    @Singleton
    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providePostThreadExecutor(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }



}