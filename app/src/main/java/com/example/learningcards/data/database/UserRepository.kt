package com.example.learningcards.data.database

import androidx.lifecycle.MutableLiveData
import com.example.learningcards.data.local.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


// Handle actions between ViewModel and DAO
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#8
class UserRepository(private val userDao: UserDao) {
//Don't use Flow, Instead LiveData?
    //val allUsers: Flow<User> = userDao.getUsernameList()
    val allUsers = MutableLiveData<List<User>>()
    val foundUser = MutableLiveData<User>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)//Launch a Dispatcher
    //Add a new user
    fun insertUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }
    // Get all users
    fun getAllUsers() {
        coroutineScope.launch(Dispatchers.IO) {
            val users = userDao.getUsernameList()
            allUsers.postValue(userDao.getAllUsers())
        }
    }
    //login
    fun login(username: String, password: String) {
    }
    //Find a user by name and pass
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User? {
        return userDao.getUserByUsernameAndPassword(username, password)
    }
    //Update user
    fun updateUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.updateUser(user)
        }
    }
    // Delete user
    fun deleteUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }
}
