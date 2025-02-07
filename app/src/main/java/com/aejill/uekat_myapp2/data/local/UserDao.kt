package com.aejill.uekat_myapp2.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query


@Dao
interface UserDao {

    @Query("SELECT * FROM usersTable ORDER BY id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM usersTable WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?

    @Query("SELECT * FROM usersTable WHERE name LIKE '%' || :query || '%' OR email LIKE '%' || :query || '%' OR address LIKE '%' || :query || '%' ORDER BY id ASC")
    fun searchUsers(query: String): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)
}
