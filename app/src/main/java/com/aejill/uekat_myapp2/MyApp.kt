package com.aejill.uekat_myapp2

import android.app.Application
import androidx.room.Room
import com.aejill.uekat_myapp2.data.local.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {
    val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "User_DB")
            .build()
    }
}