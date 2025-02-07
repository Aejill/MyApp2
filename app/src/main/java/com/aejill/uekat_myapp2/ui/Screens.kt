package com.aejill.uekat_myapp2.ui

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object UserDetailsScreen : Screen("user_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}