package com.example.listofgoods.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.listofgoods.ui.kit.ListOfGoodsAppBar
import com.example.listofgoods.ui.screen.GoodsScreen
import com.example.listofgoods.ui.theme.ListOfGoodsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListOfGoodsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        ListOfGoodsAppBar(PaddingValues())
                    }
                ) { innerPadding ->
                    GoodsScreen(paddingValues = innerPadding)
                }
            }
        }
    }
}