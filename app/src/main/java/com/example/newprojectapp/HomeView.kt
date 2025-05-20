package com.example.newprojectapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeView(viewModel: MyViewModel, navController: NavHostController) {

    var itemValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = itemValue, onValueChange = {
            if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                itemValue = it
            }
        }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = {
                if (itemValue.isNotBlank()) {
                    navController.navigate(Screen.WelcomeScreen.createRoute(itemValue.trim()))
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