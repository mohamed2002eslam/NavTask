package com.example.navtask.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navtask.MessageData

@Composable
fun FirstScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    val isButtonEnabled = text.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter message") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val messageData = MessageData(message = text)
                navController.currentBackStackEntry?.arguments?.putSerializable("messageData", messageData)
                navController.navigate("second_screen/${text}")
            },
            enabled = isButtonEnabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    val navController = rememberNavController()
    FirstScreen(navController)
}