package com.aejill.uekat_myapp2.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aejill.uekat_myapp2.data.classes.UserApi
import com.aejill.uekat_myapp2.data.local.User
import com.aejill.uekat_myapp2.data.local.UserDao
import com.aejill.uekat_myapp2.data.local.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: Flow<List<User>> = UserDao.getAllUsers()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val apiUsers = repository.getUsersFromApi()
            val userEntities = apiUsers.map { it.toUserEntity() } // Map to User entity
            _users.postValue(userEntities)
            repository.saveUsersToDb(userEntities) // Save to Room DB
        }
    }

    private fun UserApi.toUserEntity(): User = User(
        user_id = id,
        user_name = name,
        user_username = username,
        user_email = email,
        address_street = address.street,
        address_suite = address.suite,
        address_city = address.city,
        address_zipcode = address.zipcode,
        address_geo_lat = address.geo.lat,
        address_geo_lng = address.geo.lng,
        company_name = company.name,
        company_catchPhrase = company.catchPhrase,
        company_bs = company.bs,
        user_phone = phone,
        user_website = website
    )
}