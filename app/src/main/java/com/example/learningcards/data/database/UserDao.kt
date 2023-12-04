package com.example.learningcards.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningcards.data.local.User
import kotlinx.coroutines.flow.Flow

// DAO
//Data Access Object
//Handling database operations
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users ORDER BY username ASC")
    fun getUsernameList(): Flow<User>
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?

    // Add other database operations as needed
    //@Query("SELECT * FROM users ORDER BY name")
}
