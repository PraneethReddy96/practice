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


    fun setData(TransactionsModel: TransactionsModel) {

        time.text = TransactionsModel.time
        time.setTextColor(Color.parseColor(colorBlack))
        amount.text = "Available Balance :" + TransactionsModel.amount.toString()
        amount.setTextColor(Color.parseColor(colorBlack))

        if (TransactionsModel.type.equals("Credit")) {
            type.text = "Amount Credited : " + TransactionsModel.transactionAmount.toString()
            type.setTextColor(Color.parseColor(colorGreen))
        } else {

            type.text = "Amount Debited : " + TransactionsModel.transactionAmount.toString()
            type.setTextColor(Color.parseColor(colorRed))
        }
    }
}
