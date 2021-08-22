package com.praneeth.frags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.praneeth.frags.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fm = supportFragmentManager

        findViewById<FrameLayout>(R.id.flContainer1)
       var button= findViewById<Button>(R.id.btn)
       var button1= findViewById<Button>(R.id.btn1)
        findViewById<FrameLayout>(R.id.flContainer2)


        button.setOnClickListener(View.OnClickListener {
            val ft1: FragmentTransaction = fm.beginTransaction()
            val fragment2 = SecondFragment()
            ft1.replace(R.id.flContainer1, fragment2,"myFragmentTag")
            ft1.commit()


        })

        button1.setOnClickListener(View.OnClickListener {
            val ft3: FragmentTransaction = fm.beginTransaction()
            val fragment3 = Fragment3()
            ft3.replace(R.id.flContainer1, fragment3,"myFragmentTag1")
            ft3.commit()


        })


            val ft: FragmentTransaction = fm.beginTransaction()
            val fragment = FirstFragment()
            ft.add(R.id.flContainer1, fragment,"myFragmentTag")
            ft.commit()


    }


}