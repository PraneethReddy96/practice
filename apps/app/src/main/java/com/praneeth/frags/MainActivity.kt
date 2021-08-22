package com.praneeth.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        findViewById<FrameLayout>(R.id.flContainer2)

            val ft: FragmentTransaction = fm.beginTransaction()
            val fragment = FirstFragment()
            ft.add(R.id.flContainer1, fragment,"myFragmentTag")
            ft.commit()

           val ft1: FragmentTransaction = fm.beginTransaction()
           val fragment2 = SecondFragment()
           ft1.add(R.id.flContainer2, fragment2,"myFragmentTag")
           ft1.commit()



    }


}