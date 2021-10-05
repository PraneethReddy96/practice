package com.praneeth.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.praneeth.data.BuildConfig
import com.praneeth.data.Constants
import com.praneeth.data.JobExecutor
import com.praneeth.data.repository.TransactionsDataRepository
import com.praneeth.data.cache.db.TransactionsDatabase
import com.praneeth.data.cache.preferences.PreferenceManager
import com.praneeth.data.cache.transactions.TransactionsCache
import com.praneeth.data.cache.transactions.TransactionsCacheImpl
import com.praneeth.data.dataSource.transactions.TransactionsDataSourceFactory
import com.praneeth.data.mapper.*
import com.praneeth.data.network.interceptor.TransactionsNetworkInterceptor
import com.praneeth.data.network.RestFactory
import com.praneeth.data.network.remote.TransactionsRemote
import com.praneeth.data.network.remote.TransactionsRemoteImpl
import com.praneeth.data.network.service.TransactionsService
import com.praneeth.domain.executor.PostExecutionThread
import com.praneeth.domain.executor.ThreadExecutor
import com.praneeth.domain.repository.TransactionsRepository
import com.praneeth.testapp.utils.UIThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): TransactionsDatabase = Room.databaseBuilder(
        context,
        TransactionsDatabase::class.java,
        "Money_Manager"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(database: TransactionsDatabase) = database.transactionsDao()


    @Singleton
    @Provides
    fun provideMainRepository(
        transactionsDataSourceFactory: TransactionsDataSourceFactory,
        transactionsDetailsDataMapper: TransactionsModelDataMapper,
        transactionDetailsDataMapper: TransactionDetailsDataMapper,
        preferenceManager:PreferenceManager,
        mainBalanceDataMapper: MainBalanceDataMapper,
        creditDataMapper: CreditDataMapper,
        debitDataMapper: DebitDataMapper,
    ):
            TransactionsRepository =
        TransactionsDataRepository(transactionsDataSourceFactory, transactionsDetailsDataMapper,
            transactionDetailsDataMapper,preferenceManager, mainBalanceDataMapper, creditDataMapper, debitDataMapper)

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

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(TransactionsNetworkInterceptor())
            .build()
    }

    @Provides
    fun provideBaseUrl() = Constants.baseUrl

    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RestFactory.makeRetrofit(isDebug = BuildConfig.DEBUG, okHttpClient = okHttpClient)
    }

    @Provides
    @Singleton
    fun provideTransactionService(retrofit: Retrofit) =
        retrofit.create(TransactionsService::class.java)

    @Provides
    @Singleton
    fun provideTransactionRemote(transactionsRemoteImpl: TransactionsRemoteImpl): TransactionsRemote {
        return transactionsRemoteImpl
    }

    @Provides
    @Singleton
    fun provideTransactionCache(transactionsCacheImpl: TransactionsCacheImpl): TransactionsCache {
        return transactionsCacheImpl
    }


}