package com.example.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ParamScreen(navController: NavController, customParam: String?) {
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "SOY PARAMS SCREEN")
                Text(text = "Parámetro recibido: ${customParam ?: "No se recibió un parametro"}")
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "VOLVER")
                }
            }
        }
    )
}