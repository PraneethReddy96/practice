package com.praneeth.testapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.praneeth.domain.model.TransactionsModel
import com.praneeth.testapp.adapter.TransactionsAdapter
import com.praneeth.testapp.databinding.FragmentAccountDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountDetailsFragment : Fragment(R.layout.fragment_account_details) {

    lateinit var binding: FragmentAccountDetailsBinding
    private var transactionsList: MutableList<TransactionsModel> = mutableListOf()
    private var transactionsAdapter: TransactionsAdapter = TransactionsAdapter(transactionsList)
    lateinit var navController: NavController

    private val transactionsViewModel: TransactionsViewModel by
    navGraphViewModels(R.id.nav_transaction_details_xml) { defaultViewModelProviderFactory }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountDetailsBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding.btnUpdate.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.action_accountDetailsFragment_to_makeTransactionsFragment)
        })

    }



    override fun onResume() {
        super.onResume()
        buildRecyclerViewData()
        setRecyclerView()
        setBalance()
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("TAGz", "onViewStateRestored: ")
    }
    private fun setBalance() {
        transactionsViewModel.getMainBalance()
        transactionsViewModel.mainBalanceLiveData.observe(requireActivity(), Observer {

            binding.tvTotal.text =it.data?.balance.toString()

        })
    }

    private fun buildRecyclerViewData() {
        transactionsViewModel.getTransactions()
        transactionsViewModel.entityListLiveData.observe(requireActivity(), Observer {
            transactionsList.clear()
            transactionsList.addAll(it)
            transactionsAdapter.notifyDataSetChanged()

        })

    }
    private fun setRecyclerView() {
        binding.apply {
            val llManager = LinearLayoutManager(requireContext())
            rvTransactionHistoryRecyclerView.layoutManager = llManager
            rvTransactionHistoryRecyclerView.adapter = transactionsAdapter
        }
    }
}