package com.aejill.uekat_myapp2.data

import android.telecom.Call
import com.aejill.uekat_myapp2.data.classes.UserApi
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Call<List<UserApi>>
}
