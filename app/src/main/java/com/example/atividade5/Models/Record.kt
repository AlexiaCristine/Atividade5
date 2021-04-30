package com.example.atividade5.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Records")
data class Record(
    @ColumnInfo(name = "user_id") var userId: Int,
    var value: Float,
    var person: String,
    var remarks: String?,
    @ColumnInfo(name = "registered_at") var registeredAt: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}