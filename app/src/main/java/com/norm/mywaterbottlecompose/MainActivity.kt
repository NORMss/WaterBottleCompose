package com.norm.mywaterbottlecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.norm.mywaterbottlecompose.ui.theme.MyWaterBottleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWaterBottleComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var usedAmount by remember {
                        mutableStateOf(400)
                    }
                    val totalWaterAmount = remember {
                        2400
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedAmount
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Total amount is $totalWaterAmount ml"
                        )
                        Button(onClick = {
                            if (usedAmount < totalWaterAmount) {
                                usedAmount += 100
                            }
                        }) {
                            Text(text = "Drink")
                        }
                        Button(onClick = {
                            usedAmount = 0
                        }) {
                            Text(text = "Clear")
                        }
                    }
                }
            }
        }
    }
}