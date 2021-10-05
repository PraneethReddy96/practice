package com.praneeth.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.praneeth.data.entity.TransactionsCacheEntity
import io.reactivex.Observable

@Dao
interface TransactionsDao {

    @Insert
    fun insertTransaction(TransactionsCacheEntity: TransactionsCacheEntity)

    @Query(value ="select * from Transactions order by number ASC")
    fun getTransactions() : Observable<List<TransactionsCacheEntity>>

    @Query(value =  "SELECT * FROM Transactions WHERE number=(SELECT min(number) FROM Transactions)")
    fun getLatestBalance() : Observable<TransactionsCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTransactions(transactionsCacheEntity: TransactionsCacheEntity)

    @Query("SELECT * FROM Transactions ORDER BY number LIMIT 1")
    fun checkData(): Observable<TransactionsCacheEntity>

    @Query("DELETE from Transactions")
    fun delete()

}