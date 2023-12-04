package com.example.learningcards.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Card(
    @PrimaryKey @ColumnInfo(name = "id")
    val CardId: String,
    val name: String,
    val description: String,
    val tutor: String,
    val imgUrl: String = ""
)
