package com.example.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ParamScreen(navController: NavController, customParam: String?) {
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues),
                horizontalAlignment= Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (customParam?.toInt() == 0)
                        "Haz tocado el fondo"
                    else
                        "Haz tocado la carita",
                    fontSize = 30.sp)
                Box(modifier = Modifier.fillMaxWidth().height(30.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        if (customParam?.toInt() == 0)
                            FaceColor.Background.color
                        else
                            FaceColor.Face.color
                    ))
                Box(modifier = Modifier.fillMaxWidth().height(30.dp))
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "VOLVER")
                }
            }
        }
    )
}