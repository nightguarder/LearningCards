package com.example.learningcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.learningcards.compose.LearningApp
import com.example.learningcards.ui.theme.LearningCardsTheme


//Start of the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningCardsTheme {
                //Run main Class
                LearningApp()
            }
        }
    }
}