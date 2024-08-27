package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.screens.ConfigScreen
import com.example.navigation.screens.HomeScreen
import com.example.navigation.screens.ParamScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.ConfigScreen.route){
            ConfigScreen(navController)
        }
        composable(
            route = "${AppScreens.ParamScreen.route}?customParam={customParam}",
            arguments = listOf(
                navArgument("customParam") {
                    defaultValue = "VALOR_POR_DEFECTO"
                    nullable = true
                    type = NavType.StringType
                }
            )
        ){
                backStackEntry ->
            val customParam = backStackEntry.arguments?.getString("customParam")
            ParamScreen(navController, customParam)
        }
    }
}