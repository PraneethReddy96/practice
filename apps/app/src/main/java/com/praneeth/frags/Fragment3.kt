package com.praneeth.frags

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match

class Fragment3 : Fragment(R.layout.fragment_3) {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(ContentValues.TAG, "onAttach2")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ContentValues.TAG, "onCreate2")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(ContentValues.TAG, "onCreateView2")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(ContentValues.TAG, "onViewCreated2")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart2")
    }
    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume2")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause2")
    }


    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, "onStop2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(ContentValues.TAG, "onDestroyView2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy2")
    }


    override fun onDetach() {
        super.onDetach()
        Log.d(ContentValues.TAG, "onDetach2")
    }

}