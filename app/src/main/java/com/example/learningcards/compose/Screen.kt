package com.example.learningcards.compose

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String,
                    val navArguments: List<NamedNavArgument> = emptyList()) {
    data object Home : Screen("login")
    data object Welcome : Screen("welcome")

}