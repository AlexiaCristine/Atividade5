package com.example.atividade5.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    var userName: String,
    var password: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}