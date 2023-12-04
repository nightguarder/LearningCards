package com.example.learningcards.compose.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember //remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue // only if using var
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningcards.R
import com.example.learningcards.data.local.User
import com.example.learningcards.ui.theme.PrimaryDark
import com.example.learningcards.ui.theme.PrimaryOrange
import com.example.learningcards.ui.theme.firaSansFamily
import com.example.learningcards.viewmodels.UserViewModel

@Composable
fun LoginScreen(
    userViewModel: UserViewModel,
    navController: NavController
) {
    //Example data
    userViewModel.insertUser(User(username = "Cyril", password = "example"))
    //Main Login screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            //Padding for top and bottom of the view screen
            .padding(horizontal = 12.dp, vertical = 12.dp)
            .border(width = 1.dp, Color.Gray),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .border(width = 1.dp, Color.Cyan)
        ) {
            // TextView with fontFamily="@font/montserrat_bold"
            Text(
                text = "Learning Cards",
                fontSize = 50.sp,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                style = MaterialTheme.typography.displayLarge,
                overflow = TextOverflow.Visible,
            )
        }
        // TextView with fontFamily="@font/montserrat_light"
        Text(
            text = "Learn anything from anywhere",
            fontSize = 22.sp,
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            color = Color.Gray,
        )

        // ImageView with background="@drawable/ic_illustration_login"
        //NENI MOJE TVORBA
        Image(
            painter = painterResource(id = R.drawable.ic_illustration_login),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .scale(1f) // this will zoom the image
                .padding(top = 10.dp)
        )
        //Render the rest
        //Navigate to Home Screen
        LoginForm(navController)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(navController: NavController) {
    //Variables for LoginForm
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Button(
            onClick = { /*TODO: LoginClick*/ },
            colors = ButtonDefaults.buttonColors(PrimaryOrange),
                modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                color = Color.Black
            )

        }
        // Input fields for username and password
        // TextView for "Don't you have an account? + Button
        Text(
            text = "Don't you have an account?",
            fontSize = 16.sp,
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Button(
            onClick = {   /*TODO: Create Register page*/ },
            colors = ButtonDefaults.buttonColors(PrimaryDark),
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp)
        ) {
            Text(text = "Create account",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                )

        }

    }

}