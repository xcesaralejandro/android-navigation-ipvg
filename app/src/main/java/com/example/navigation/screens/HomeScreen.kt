package com.example.navigation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.navigation.AppScreens

enum class FaceColor(val color: Color) {
    Background(Color.Gray),
    Face(Color.Yellow)
}

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                HappyFace(navController)
            }
        }
    )
}


@Composable
fun HappyFace(navController: NavController) {
    val faceMatrix = listOf(
        listOf(0, 0, 0, 0, 0),
        listOf(0, 1, 0, 1, 0),
        listOf(0, 0, 0, 0, 0),
        listOf(1, 0, 0, 0, 1),
        listOf(1, 1, 1, 1, 1),
        listOf(0, 0, 0, 0, 0)
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        faceMatrix.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                row.forEach { cell ->
                    Box(
                        modifier = Modifier
                            .background(
                                if (cell == 0)
                                    FaceColor.Background.color
                                else 
                                    FaceColor.Face.color
                            )
                            .weight(1f)
                            /* Aumentar para explicar scrollable :) */
                            .height(100.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ){
                                navController.navigate(
                                    "${AppScreens.ParamScreen.route}?customParam=$cell"
                                )
                            }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun facePreview(){
    HappyFace(NavController(LocalContext.current))
}