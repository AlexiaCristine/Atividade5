package com.example.atividade5.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.atividade5.Models.Record
import com.example.atividade5.Models.User
import com.example.atividade5.database.daos.RecordsDAO
import com.example.atividade5.database.daos.UsersDAO

@Database(entities = [User::class, Record::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDAO
    abstract fun recordsDao(): RecordsDAO
}