package com.praneeth.testapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.testapp.R

class TransactionsAdapter(private val transactionList: MutableList<TransactionsModel>) : RecyclerView.Adapter<TransactionsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transactions_item_layout,parent,false)
        return TransactionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        var transactionsEntity = transactionList[position]
        holder.setData(transactionsEntity)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }
}