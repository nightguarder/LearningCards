package com.example.learningcards.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//This is your local db
//Create an Entity
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#4
@Entity(tableName = "users")
data class User(
    //Prepare your database table
    //PrimaryKey is already NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,

    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String,
    //@ColumnInfo(name = "email")
    //var email: String,


)
