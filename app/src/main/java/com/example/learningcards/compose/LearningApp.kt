@file:Suppress("NAME_SHADOWING")

package com.example.learningcards.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningcards.compose.login.LoginScreen
import com.example.learningcards.compose.welcome.WelcomeScreen
import com.example.learningcards.viewmodels.UserViewModel

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
    val navController = rememberNavController()

    val userViewModel: UserViewModel = viewModel()
    //NavHost start at Welcome screen
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        //Welcome screen
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                //TODO: Implement OnStart navigation
                onContinueClick = {
                    // Navigate to the Login screen when the button is clicked
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(route = Screen.Login.route, ){
            LoginScreen(userViewModel = userViewModel , navController = navController)
        }

        }
}