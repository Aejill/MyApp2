package com.aejill.uekat_myapp2.ui.userDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UserDetailsScreen(
    navController: NavController,
    userId: Int,
    viewModel: VM_UserDetailsScreen,
    onBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadUserDetails()
    }
    val user = viewModel.user

    Scaffold(topBar = {
        TopAppBar(title = { Text("User Details") }, navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        })
    }) {
        user?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SectionCard("User Details", Color(0xFFB2DFDB), listOf(
                    "Name: ${it.user_name}",
                    "Username: ${it.user_username}",
                    "Email: ${it.user_email}",
                    "Phone: ${it.user_phone}",
                    "Website: ${it.user_website}"
                ))
                SectionCard("Company", Color(0xFFFFCC80), listOf(
                    "Company: ${it.company_name}",
                    "Catchphrase: ${it.company_catchPhrase}",
                    "Business: ${it.company_bs}"
                ))
                SectionCard("Address", Color(0xFF90CAF9), listOf(
                    "Street: ${it.address_street}",
                    "Suite: ${it.address_suite}",
                    "City: ${it.address_city}",
                    "Zip: ${it.address_zipcode}",
                    "Geo: ${it.address_geo_lat}, ${it.address_geo_lng}"
                ))
            }
        }
    }
}

@Composable
fun SectionCard(title: String, color: Color, details: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(2.dp, color, shape = RoundedCornerShape(12.dp))
            .background(color.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(title, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        details.forEach { Text(it, color = Color.Black) }
    }
}


