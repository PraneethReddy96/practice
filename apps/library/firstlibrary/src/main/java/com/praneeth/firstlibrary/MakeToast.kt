package com.praneeth.firstlibrary

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MakeToast {


    companion object{

        fun snackBar(context: Context, message: String){

            Toast.makeText(context,message,Toast.LENGTH_LONG).show()

        }
    }


}