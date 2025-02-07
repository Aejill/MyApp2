package com.aejill.uekat_myapp2.ui.userDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.launch

class VM_UserDetailsScreen : ViewModel() {
    var user by mutableStateOf<User?>(null)
        private set

    fun loadUserDetails() {}
}