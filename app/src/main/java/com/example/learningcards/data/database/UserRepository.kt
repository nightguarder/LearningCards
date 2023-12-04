package com.example.learningcards.data.database

import com.example.learningcards.data.local.User
import kotlinx.coroutines.flow.Flow


// Handle actions between ViewModel and DAO
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#8
class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<User> = userDao.getUsernameList()
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    // Add other repository methods as needed
}
