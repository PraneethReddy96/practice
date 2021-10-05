package com.praneeth.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.praneeth.composebasics.ui.HomeScreen
import com.praneeth.composebasics.ui.theme.ComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContent {
                    ComposeBasicsTheme() {
                        HomeScreen()
                    }
                }
       }

    @Preview
    @Composable
    @ExperimentalFoundationApi
    fun Start(){
        HomeScreen()
    }

}
