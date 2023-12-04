package com.example.learningcards.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//This is your local db
//Create an Entity
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#4
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val username: String,
    val password: String
)
