package com.example.learningcards.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcards.data.database.UserRepository
import com.example.learningcards.data.local.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//ViewModel which interacts with compose LoginScreen
/*
class LoginViewModel(private val userRepository,application: Application) : ViewModel() {

    private val _loginStatus = MutableLiveData<LoginStatus>()
    val userList: LiveData<List<User>> = userRepository.allUsers
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val foundUser: LiveData<User> = userRepository.foundUser

    //Get all users table
    fun getAllUsers(){
        userRepository.getAllUsers()
    }

    //Register user
    fun addUser(user: User) {
        userRepository.insertUser(user)
        getAllUsers()
    }
    fun updateUserDetails(user: User) {
        userRepository.updateUser(user)
        getAllUsers()
    }
    //Login
    sealed class LoginStatus {
        object Loading : LoginStatus()
        data class Success(val user: User) : LoginStatus()
        data class Failure(val errorMessage: String) : LoginStatus()
    }
    fun login(username: String, password: String) {
        coroutineScope.launch {
            val user = userRepository.getUserByUsernameAndPassword(username, password)
            if (user != null) {
                _loginStatus.value = LoginStatus.Success(user)
            } else {
                _loginStatus.value = LoginStatus.Failure("Invalid username or password")
            }
        }
    }
}

class LoginViewModel2(private val userRepository: UserRepository):ViewModel(){
    // Existing code...

    private val _loginStatus = MutableLiveData<LoginStatus>()
    val loginStatus: LiveData<LoginStatus>
        get() = _loginStatus

    sealed class LoginStatus {
        object Loading : LoginStatus()
        data class Success(val user: User) : LoginStatus()
        data class Failure(val errorMessage: String) : LoginStatus()
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            // Set loading state
            _loginStatus.value = LoginStatus.Loading

            // Attempt login
            val user = userRepository.getUserByUsernameAndPassword(username, password)

            if (user != null) {
                // Set success state
                _loginStatus.value = LoginStatus.Success(user)
            } else {
                // Set failure state
                _loginStatus.value = LoginStatus.Failure("Invalid username or password")
            }
        }
    }
}
*/

