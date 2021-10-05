package com.praneeth.testapp.adapter

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.praneeth.data.Constants.colorBlack
import com.praneeth.data.Constants.colorGreen
import com.praneeth.data.Constants.colorRed
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.testapp.R

class TransactionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var time = view.findViewById<TextView>(R.id.tvTransactionTime)
    private var amount = view.findViewById<TextView>(R.id.tvTransactionAmount)
    private var type = view.findViewById<TextView>(R.id.tvTransactionType)


    fun setData(transactionsModel: TransactionsModel) {

        time.text = transactionsModel.time.toString()
        time.setTextColor(Color.parseColor(colorBlack))

        if ( transactionsModel.type.equals("credit")) {
            type.text = "Amount Credited :"+ transactionsModel.transactionAmount.toString()
            type.setTextColor(Color.parseColor(colorGreen))
            amount.text = "Available Balance :" + transactionsModel.amount.toString()
            amount.setTextColor(Color.parseColor(colorBlack))

        } else {

            type.text = "Amount Debited :"+ transactionsModel.transactionAmount.toString()
            type.setTextColor(Color.parseColor(colorRed))
            amount.text = "Available Balance :" + transactionsModel.amount.toString()
            amount.setTextColor(Color.parseColor(colorBlack))
        }
    }
}
