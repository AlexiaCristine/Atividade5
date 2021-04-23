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
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{

            if (edUsername.text.trim().isNotEmpty() || edPassword.text.trim().isNotEmpty()){
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

