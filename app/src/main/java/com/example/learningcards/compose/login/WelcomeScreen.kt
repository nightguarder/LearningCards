package com.example.learningcards.compose.login

import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcards.R
import com.example.learningcards.ui.theme.PrimaryOrange
import com.example.learningcards.ui.theme.firaSansFamily

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 12.dp,)
            .border(width = 1.dp, Color.Green)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                //.border(width = 1.dp, Color.Cyan)
        ) {
            Text(
                text = "Welcome back!",
                fontSize = 50.sp,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                style = MaterialTheme.typography.displayLarge,
                overflow = TextOverflow.Visible,
                modifier = Modifier
            )
        }
        Text(
            text = "Study with Learning Cards App",
            fontSize = 22.sp,
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            color = Color.Gray,
        )
        // Image container
        Image(
            painter = painterResource(id = R.drawable.ic_illustration_welcome),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .scale(1f) // this will zoom the image
                .border(width = 1.dp, Color.Gray)
        )
        SwipeUpIndicator()
    }
}

@Composable
fun SwipeUpIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(5.dp)
        ) {
            Button(
                onClick = { /* TODO: Handle button click */ },
                colors = ButtonDefaults.buttonColors(PrimaryOrange),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .size(86.dp)
            ) {
                // TODO: Add button content
                Text(
                    text = "CONTINUE",
                    fontSize = 22.sp,
                    fontFamily = firaSansFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,

                )
        }
        }

    }

}