package com.example.newprojectapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavHostController) {

    var nameValue by remember { mutableStateOf("") }
    var lastNameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //first Name
        OutlinedTextField(
            value = nameValue,
            singleLine = true,
            onValueChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                    nameValue = it
                }
            },
            label = { Text("First Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(16.dp))

        //Last Name
        OutlinedTextField(
            value = lastNameValue,
            singleLine = true,
            onValueChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                    lastNameValue = it
                }
            },
            label = { Text("Last Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(16.dp))

        //email
        OutlinedTextField(
            value = emailValue,
            singleLine = true,
            onValueChange = {
                emailValue = it
            },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(16.dp))

        //password
        OutlinedTextField(
            value = passwordValue,
            singleLine = true,
            onValueChange = {
                passwordValue = it
            },
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        //Enter Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                if (listOf(
                        nameValue,
                        lastNameValue,
                        emailValue,
                        passwordValue
                    ).all { it.isNotBlank() }
                ) {
                    navController.navigate(
                        Screen.WelcomeScreen.createRoute(
                            name = nameValue.trim(),
                            lastName = lastNameValue.trim(),
                            email = emailValue.trim(),
                            password = passwordValue.trim()
                        )
                    )
                }
            },
        ) {
            Text(text = "Enter")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    HomeView(viewModel = viewModel(), navController = rememberNavController())
}