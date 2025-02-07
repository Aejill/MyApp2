package com.aejill.uekat_myapp2.data.local

import com.aejill.uekat_myapp2.data.ApiService
import com.aejill.uekat_myapp2.data.classes.UserApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService, private val userDao: UserDao) {

    suspend fun getUsersAPI(): List<UserApi> {
        return try {
            apiService.getUsers()
        } catch (e: Exception) {
            println("API Error: ${e.message}")
            emptyList()
        }
    }

    suspend fun saveUsersToDB(users: List<User>) {
        userDao.insertUsers(users)
    }

    fun getUsersDB(): Flow<List<User>> = userDao.getAllUsers()

    fun searchUsers(query: String): Flow<List<User>> = userDao.searchUsers(query)
}