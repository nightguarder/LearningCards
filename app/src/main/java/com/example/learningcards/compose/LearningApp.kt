package com.example.learningcards.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningcards.compose.welcome.WelcomeScreen

@Preview(showBackground = true)
@Composable
fun LearningApp() {
    //TODO: Tutorial: Navigate between screens with Compose
    val navController = rememberNavController()
    LearningNavHost(
        navController = navController
    )
    // Decide to Login or display Home

}
@Composable
fun LearningNavHost( navController: NavHostController){
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen()
        }

        }
}