package com.aejill.uekat_myapp2.ui.main


import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aejill.uekat_myapp2.data.local.User
import com.aejill.uekat_myapp2.data.local.UserDao
import com.aejill.uekat_myapp2.data.local.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VM_MainScreen @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    private val _searchText = MutableStateFlow(TextFieldValue(""))
    val searchText: StateFlow<TextFieldValue> = _searchText.asStateFlow()

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            userRepository.getUsersDB().collect { userList ->
                _users.value = userList.sortedBy { it.user_id }
            }
        }
    }

    fun onSearchTextChange(text: TextFieldValue) {
        _searchText.value = text
        filterUsers(text.text)
    }

    private fun filterUsers(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) {
                userRepository.getUsersDB().collect { _users.value = it.sortedBy { user -> user.user_id } }
            } else {
                userRepository.searchUsers(query).collect { _users.value = it }
            }
        }
    }
}