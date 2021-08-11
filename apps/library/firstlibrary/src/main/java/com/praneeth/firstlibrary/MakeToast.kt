package com.praneeth.firstlibrary

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

class MakeToast {


    companion object{

        fun snackBar(context: Context, message: String, view: View){

            Snackbar.make(context,view,message,2000)

        }

    }


}