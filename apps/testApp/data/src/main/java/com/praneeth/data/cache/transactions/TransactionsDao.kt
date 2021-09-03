package com.praneeth.data.cache.transactions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.praneeth.data.entity.TransactionsEntity
import io.reactivex.Observable

@Dao
interface TransactionsDao {

    @Insert
    fun insertTransaction(TransactionsEntity: TransactionsEntity)

    @Query(value ="select * from Transactions order by id DESC")
    fun getTransactions() : Observable<List<TransactionsEntity>>

    @Query(value =  "SELECT * FROM Transactions WHERE id=(SELECT max(id) FROM Transactions)")
    fun getLatestBalance() : TransactionsEntity


    @Query("SELECT * FROM Transactions ORDER BY id LIMIT 1")
    fun checkData(): TransactionsEntity

}