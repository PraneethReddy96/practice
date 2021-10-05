package com.praneeth.data.network.remote


import android.util.Log
import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import com.praneeth.data.model.*
import com.praneeth.data.network.service.TransactionsService
import com.praneeth.data.model.TransactionsEntity
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

fun <T> Response<T>.getMessageFromErrorBody(): String? {
    val gson = Gson()
    val type = object : TypeToken<Any>() {}.type
    var errorResponse: String? = null
    try {
        val errorResponseObj: Any = gson.fromJson(this.errorBody()!!.charStream(), type)
        errorResponse = (errorResponseObj as LinkedTreeMap<String, Any>)["message"] as String?
    } catch (e: Exception) {
    }

    return errorResponse
}


class TransactionsRemoteImpl @Inject constructor(private val transactionsService: TransactionsService ): TransactionsRemote {


    override fun credit(amount: String, title:String): Observable<CreditResponseEntity> {

        var creditResponseBody = CreditResponseBody(amount,title)
        var result=transactionsService.credit(creditResponseBody).map {
            if (it.isSuccessful) {
                Log.d("check", it.body().toString())
                return@map it.body()!!

            } else {
                Log.d("check2", it.getMessageFromErrorBody().toString())
                val errorMsg = it.getMessageFromErrorBody()
                throw Exception(errorMsg ?: "Something went wrong: error ${it.code()}")
            }
        }.map {
            Log.d("check", it.toString())
            return@map it
        }
        return result
    }


    override fun debit(amount: String,title:String): Observable<DebitResponseEntity>{

        var debitResponseBody = DebitResponseBody(amount,title)
        var result=transactionsService.debit(debitResponseBody).map {
            if (it.isSuccessful) {
                Log.d("check", it.body().toString())
                return@map it.body()!!

            } else {
                Log.d("check2", it.getMessageFromErrorBody().toString())
                val errorMsg = it.getMessageFromErrorBody()
                throw Exception(errorMsg ?: "Something went wrong: error ${it.code()}")
            }
        }.map {
            Log.d("check", it.toString())
            return@map it
        }
        return result
    }

    override fun getMainBalance(): Observable<MainBalanceResponseEntity> {


        var result=transactionsService.getBalance().map {
            if (it.isSuccessful) {
                Log.d("check", it.body().toString())
                return@map it.body()!!

            } else {
                Log.d("check2", it.getMessageFromErrorBody().toString())
                val errorMsg = it.getMessageFromErrorBody()
                throw Exception(errorMsg ?: "Something went wrong: error ${it.code()}")
            }
        }.map {
            Log.d("check", it.toString())
            return@map it
        }
        return result
    }

    override fun getTransactions(): Observable<List<TransactionsEntity>> {

        var result=transactionsService.getTransactions().map {
            if (it.isSuccessful) {
                Log.d("check", it.body().toString())
                return@map it.body()!!.transactions!!

            } else {
                Log.d("check2", it.getMessageFromErrorBody().toString())
                val errorMsg = it.getMessageFromErrorBody()
                throw Exception(errorMsg ?: "Something went wrong: error ${it.code()}")
            }
        }.map {
            Log.d("check", it.toString())
            return@map it
        }
        return result
    }
}