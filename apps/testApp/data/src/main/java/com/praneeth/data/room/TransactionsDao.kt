package com.praneeth.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.praneeth.domain.transactionsEntity
import io.reactivex.Observable


@Dao
interface TransactionsDao {

    @Insert
    fun insertTransaction(transactionsEntity : transactionsEntity)

    @Query(value ="select * from Transactions order by id DESC")
    fun getTransactions() : Observable<List<transactionsEntity>>

    @Query(value =  "SELECT * FROM Transactions WHERE id=(SELECT max(id) FROM Transactions)")
    fun getLatestBalance() : transactionsEntity


    @Query("SELECT * FROM Transactions ORDER BY id LIMIT 1")
    fun checkData(): transactionsEntity

}