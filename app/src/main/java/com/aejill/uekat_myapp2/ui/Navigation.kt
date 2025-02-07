package com.aejill.uekat_myapp2.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aejill.uekat_myapp2.ui.main.MainScreen
import com.aejill.uekat_myapp2.ui.main.VM_MainScreen
import com.aejill.uekat_myapp2.ui.userDetails.UserDetailsScreen
import kotlinx.coroutines.MainScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController, VM_MainScreen())
        }
        composable(
            route = Screen.UserDetailsScreen.route + "/{userId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.IntType
                    defaultValue = "0"
                    nullable = false}
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            UserDetailsScreen(
                navController,
                userId = userId,
                viewModel = VM_MainScreen(),
                onBack = MainScreen(navController, VM_MainScreen())
            )
        }
    }
}
