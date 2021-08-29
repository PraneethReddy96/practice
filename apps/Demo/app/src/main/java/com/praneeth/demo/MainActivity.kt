package com.praneeth.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.praneeth.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {



            btnUpdate.setOnClickListener(View.OnClickListener {

                containerCardView.visibility = View.GONE
                transactionContainerCardView.visibility = View.VISIBLE
                tvTransactionsHeader.visibility= View.GONE
rvTransactionHistoryRecyclerView.visibility=View.GONE

            })

            btnCredit.setOnClickListener(View.OnClickListener {

               containerCardView.visibility = View.VISIBLE
                transactionContainerCardView.visibility = View.GONE
                tvTransactionsHeader.visibility= View.VISIBLE
                rvTransactionHistoryRecyclerView.visibility=View.VISIBLE
            })


            btnDebit.setOnClickListener(View.OnClickListener {

                containerCardView.visibility = View.VISIBLE
                transactionContainerCardView.visibility = View.GONE
                tvTransactionsHeader.visibility= View.VISIBLE
                rvTransactionHistoryRecyclerView.visibility=View.VISIBLE

            })

        }

    }
}