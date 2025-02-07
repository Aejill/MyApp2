package com.aejill.uekat_myapp2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aejill.uekat_myapp2.data.ApiService
import com.aejill.uekat_myapp2.data.local.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class VM_MainActivity @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = apiService.getUsers()
                _users.value = response.body() ?: emptyList()
            } catch (e: Exception) {
                // Handle error
                Log.e("MainViewModel", "Error fetching users", e)
            }
        }
    }
}