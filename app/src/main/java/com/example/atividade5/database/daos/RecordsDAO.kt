package com.example.atividade5.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.atividade5.Models.Record

@Dao
interface RecordsDAO {
    @Insert
    fun  insert(record: Record): Long

    @Query("SELECT * FROM records WHERE user_id = :userId")
    fun getAll(userId: Int): List<Record>
}