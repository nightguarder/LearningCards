package com.example.learningcards.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.learningcards.data.local.User
import kotlinx.coroutines.flow.Flow

// DAO
//Data Access Object
//Handling database operations
//DAO checks for queries on compile time & gives an error if found any.
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    //return all users to a Flow <List>
    @Query("SELECT * FROM users ORDER BY username ASC")
    fun getUsernameList(): Flow<User>
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?

    // Add other database operations as needed Delete Insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addnewUser(user: User)
    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
    //@Query("SELECT * FROM users ORDER BY name")
}
