package com.praneeth.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.praneeth.testapp.databinding.ActivityTransactionsBaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionsBaseActivity : AppCompatActivity() {

    lateinit var binding : ActivityTransactionsBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

