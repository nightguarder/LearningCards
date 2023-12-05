package com.example.learningcards.viewmodels

import android.app.Application
import android.database.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcards.data.database.UserRepository
import com.example.learningcards.data.local.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(repository: UserRepository
) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val _loginStatus = MutableLiveData<LoginStatus>()
    val loginStatus: LiveData<LoginStatus>
        get() = _loginStatus

    sealed class LoginStatus {
        object Loading : LoginStatus()
        data class Success(val user: User) : LoginStatus()
        data class Failure(val errorMessage: String) : LoginStatus()
    }

    fun attemptLogin(username: String, password: String) {
        /*viewModelScope.launch {
            // Set loading state
            _loginStatus.value = LoginStatus.Loading

            // Attempt login
            val user = repository.getUserByUsernameAndPassword(username, password)

            if (user != null) {
                _loginStatus.value = LoginStatus.Success(user)
            } else {
                _loginStatus.value = LoginStatus.Failure("Invalid username or password")
            }
        }
         */
    }
}


