package com.praneeth.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import com.praneeth.testapp.databinding.FragmentMakeTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MakeTransactionsFragment : Fragment(R.layout.fragment_make_transactions) {


    lateinit var binding: FragmentMakeTransactionsBinding
    lateinit var navController: NavController
    private val transactionsViewModel: TransactionsViewModel by
    navGraphViewModels(R.id.nav_transaction_details_xml) { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMakeTransactionsBinding.bind(view)
        navController= Navigation.findNavController(view)

        creditAmount()
        debitAmount()
    }

    private fun debitAmount() {

        binding.btnDebit.setOnClickListener(View.OnClickListener {

            transactionsViewModel.debit(binding.etTransactionTitle.text.toString(),
                binding.etTransactionAmount.text.toString().toDouble(),binding.btnDebit.text.toString())

            navController.navigate(R.id.action_makeTransactionsFragment_to_accountDetailsFragment)
            binding.etTransactionAmount.setText("")
            binding.etTransactionTitle.setText("")
            Toast.makeText(requireContext(),"Transaction Successful!",Toast.LENGTH_SHORT).show()
        })

    }

    private fun creditAmount() {
       binding.btnCredit.setOnClickListener(View.OnClickListener {

           transactionsViewModel.credit(binding.etTransactionTitle.text.toString(),
               binding.etTransactionAmount.text.toString().toDouble(),binding.btnCredit.text.toString())


           navController.navigate(R.id.action_makeTransactionsFragment_to_accountDetailsFragment)
           binding.etTransactionAmount.setText("")
           binding.etTransactionTitle.setText("")
           Toast.makeText(requireContext(),"Transaction Successful!",Toast.LENGTH_SHORT).show()
       })
    }

}