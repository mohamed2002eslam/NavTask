package com.example.navtask.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecondScreen(navController: NavController, message: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to First Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    val navController = rememberNavController()
    SecondScreen(navController, message = "Preview Message")
}