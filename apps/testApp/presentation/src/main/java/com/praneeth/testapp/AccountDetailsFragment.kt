package com.praneeth.testapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.praneeth.domain.transactionsEntity
import com.praneeth.testapp.adapter.TransactionsAdapter
import com.praneeth.testapp.databinding.FragmentAccountDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountDetailsFragment : Fragment(R.layout.fragment_account_details) {

    lateinit var binding: FragmentAccountDetailsBinding
    private var transactionsList : MutableList<transactionsEntity> = mutableListOf()
    private var transactionsAdapter:TransactionsAdapter = TransactionsAdapter(transactionsList)
    lateinit var navController: NavController
    private val transactionsViewModel: TransactionsViewModel by
    navGraphViewModels(R.id.nav_transaction_details_xml) { defaultViewModelProviderFactory }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountDetailsBinding.bind(view)
        navController = Navigation.findNavController(view)


        setBalance()
        binding.btnUpdate.setOnClickListener(View.OnClickListener {
                navController.navigate(R.id.action_accountDetailsFragment_to_makeTransactionsFragment)
            })

        buildRecyclerViewData()
        setRecyclerView()
        Log.d("TAG", "onViewCreated: ")
    }

    private fun setBalance() {
        binding.tvTotal.text= transactionsViewModel.getMainBalance().toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG", "onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: ")
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
            rvTransactionHistoryRecyclerView.adapter =transactionsAdapter
        }

    }

}