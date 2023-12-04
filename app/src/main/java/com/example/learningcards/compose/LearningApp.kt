package com.example.learningcards.compose

import android.app.Activity
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


import com.example.learningcards.compose.login.WelcomeScreen

@Preview(showBackground = true)
@Composable
fun LearningApp() {
    val activity = (LocalContext.current as Activity)
    //remember the state of the app
    Surface {
        WelcomeScreen()
    }

    // Decide to Login or display Home
    // Set up the main screen based on the login state

}
