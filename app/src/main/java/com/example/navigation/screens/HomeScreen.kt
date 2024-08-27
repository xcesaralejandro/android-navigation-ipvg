package com.example.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.navigation.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "SOY HOME SCREEN")
                Button(onClick = {
                    navController.navigate(AppScreens.ConfigScreen.route)
                }) {
                    Text(text = "IR A CONFIG SCREEN")
                }
            }
        }
    )
}