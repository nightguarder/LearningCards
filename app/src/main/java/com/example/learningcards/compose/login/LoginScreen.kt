package com.example.learningcards.compose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningcards.R
import com.example.learningcards.data.local.User
import com.example.learningcards.ui.theme.Blue
import com.example.learningcards.ui.theme.LightBlue
import com.example.learningcards.ui.theme.PrimaryBlack
import com.example.learningcards.ui.theme.PrimaryOrange
import com.example.learningcards.ui.theme.PrimaryPink
import com.example.learningcards.ui.theme.PrimaryYellow
import com.example.learningcards.ui.theme.firaSansFamily
import com.example.learningcards.viewmodels.UserViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewModelScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel //Hilt
import com.example.learningcards.compose.Screen
import com.example.learningcards.viewmodels.LoginViewModel

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
fun LoginForm(navController: NavController, ) {
    val viewModel: LoginViewModel = hiltViewModel()
    //Variables for LoginForm
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val maxLength = 125
    Column {

        Text(
            text = "Username",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            color = PrimaryBlack
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryBlack,
                cursorColor = Color.Black,
                disabledLabelColor = LightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) username = it
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (username.isNotEmpty()) {
                    IconButton(onClick = { username = "" }) {
                    }
                }
            }
        )
        //Password TextField
        //Label
        Text(
            text = "Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            color = PrimaryBlack
        )
        //TextField
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryPink,
                cursorColor = Color.Black,
                disabledLabelColor = LightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) password = it
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (password.isNotEmpty()) {
                    IconButton(onClick = { password = "" }) {

                    }
                }
            }
        )
        Text(
            text = "${password.length}/ $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = Blue
        )
        Button(
            onClick = { viewModel.attemptLogin(username,password) },
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
        Column (modifier = Modifier
            .align(Alignment.CenterHorizontally))
        {
            Button(
                onClick = {   /*TODO: Create Register page*/ },
                colors = ButtonDefaults.buttonColors(PrimaryYellow),
                modifier = Modifier
                    .height(50.dp)
                    .padding(5.dp)
            ) {
                //TODO: Align the text!!!
                Text(
                    textAlign = TextAlign.Center,
                    text = "Create account",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = firaSansFamily,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Normal,

                )
            }
        }
    }
    }