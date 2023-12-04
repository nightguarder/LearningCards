package com.example.learningcards.compose

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String,
                    val navArguments: List<NamedNavArgument> = emptyList()) {
    data object Login : Screen("login")
    data object Welcome : Screen("welcome")
    data object Home    : Screen("home")

}