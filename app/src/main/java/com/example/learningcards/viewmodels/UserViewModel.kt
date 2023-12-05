package com.example.learningcards.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcards.data.database.AppDatabase
import com.example.learningcards.data.database.UserDao
import com.example.learningcards.data.database.UserRepository
import com.example.learningcards.data.local.User
import kotlinx.coroutines.launch

// UserViewModel.kt
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao: UserDao
    private val repository: UserRepository

    init {
        val database = AppDatabase.getDatabase(application)
        userDao = database.userDao()
        repository = UserRepository(userDao)
    }

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

}
