package com.example.atividade5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.atividade5.Models.User
import com.example.atividade5.database.AppDatabase
import com.example.atividade5.database.daos.UsersDAO
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var dao: UsersDAO

    fun createDB() {
        //create DB instance
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "user-db"
        )
            .allowMainThreadQueries()
            .build()

        //get DAO
        dao = db.usersDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        createDB()
        btnRegister.setOnClickListener {

            val password = editPassword.text.trim().toString()
            val username = editUsername.text.trim().toString()

            if (username.isNotEmpty() || password.isNotEmpty()) {
                val user = User(username, password)
                add(user)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "registro invalida", Toast.LENGTH_LONG).show()
            }
        }

        tvLogin.setOnClickListener {
            finish()
        }
    }

    fun add(user: User) {
        user.id = dao.insert(user)
    }
}