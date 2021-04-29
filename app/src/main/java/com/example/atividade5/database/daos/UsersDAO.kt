package com.example.atividade5.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.atividade5.Models.User

@Dao
interface UsersDAO {
    @Insert
    fun  insert(user: User): Long

    @Insert
    fun insertMany(vararg users: User): LongArray

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE id IN (:ids)")
    fun getAllByIds(ids: IntArray): List<User>

    @Query("SELECT * FROM users WHERE userName = :username AND password = :password")
    fun getByUserAndPassword(username: String, password: String): User?
}