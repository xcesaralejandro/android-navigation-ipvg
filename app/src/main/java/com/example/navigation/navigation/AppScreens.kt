package com.example.navigation.navigation

sealed class AppScreens (
    val route: String
){
    object HomeScreen: AppScreens("HomeScreen")
    object ConfigScreen: AppScreens("ConfigScreen")
}