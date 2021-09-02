package com.praneeth.testapp.adapter

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.praneeth.domain.transactionsEntity
import com.praneeth.testapp.R

class TransactionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var time = view.findViewById<TextView>(R.id.tvTransactionTime)
    var amount = view.findViewById<TextView>(R.id.tvTransactionAmount)
    var type = view.findViewById<TextView>(R.id.tvTransactionType)


    fun setData(transactionsEntity: transactionsEntity) {

        time.text = transactionsEntity.time
        amount.text = transactionsEntity.amount.toString()

        if (transactionsEntity.type.equals("Credit")) {
            type.text = transactionsEntity.type
            type.setTextColor(Color.parseColor("#32CD32"))
        } else {

            type.text = transactionsEntity.type
            type.setTextColor(Color.parseColor("#FF0000"))
        }
    }
}
