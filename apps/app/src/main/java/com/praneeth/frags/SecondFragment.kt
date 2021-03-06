package com.praneeth.frags

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.praneeth.frags.R


class SecondFragment : Fragment(R.layout.fragment_second) {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(ContentValues.TAG, "onAttach1")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ContentValues.TAG, "onCreate1")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(ContentValues.TAG, "onCreateView1")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(ContentValues.TAG, "onViewCreated1")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart1")
    }
    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume1")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause1")
    }


    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, "onStop1")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(ContentValues.TAG, "onDestroyView1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy1")
    }


    override fun onDetach() {
        super.onDetach()
        Log.d(ContentValues.TAG, "onDetach1")
    }

}


