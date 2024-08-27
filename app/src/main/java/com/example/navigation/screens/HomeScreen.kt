package com.example.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.navigation.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    var textState by remember { mutableStateOf("") }
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "SOY HOME SCREEN")
                Button(onClick = {
                    navController.navigate(AppScreens.ConfigScreen.route)
                }) {
                    Text(text = "IR A CONFIG SCREEN")
                }
                TextField(
                    value = textState,
                    onValueChange = { newValue -> textState = newValue },
                    label = { Text("Ingrese el parametro") }
                )
                Button(onClick = {
                    navController.navigate("${AppScreens.ParamScreen.route}?customParam=${textState}")
                }) {
                    Text(text = "IR A PARAMS SCREEN")
                }
            }
        }
    )
}