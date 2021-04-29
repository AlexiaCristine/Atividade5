package com.example.atividade5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.room.Room
import com.example.atividade5.database.AppDatabase
import com.example.atividade5.database.daos.UsersDAO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var dao: UsersDAO

     fun createDB(){
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
        setContentView(R.layout.activity_login)
        createDB()
        btnLogin.setOnClickListener{

            val password = editPassword.text.trim().toString()
            val username = editUsername.text.trim().toString()
            val user = dao.getByUserAndPassword(username, password)

            if (user != null) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                //val homeFragment = MainFragment()
                //useFragment(homeFragment)
            }
            else{
                Toast.makeText(this, "informação invalida", Toast.LENGTH_LONG).show();

            }

        }
            tvRegister.setOnClickListener{
                val intent = Intent( this, RegisterActivity::class.java)
                startActivity(intent)

            }

    }
    private fun useFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            setContentView(R.layout.fragment_main)
        }
    }
}

