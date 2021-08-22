package com.praneeth.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.praneeth.firstlibrary.MakeToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       MakeToast.snackBar(this,"MY FIRST LIBRARY")
    }
}