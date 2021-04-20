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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener{

            if (edUsername.text.trim().isNotEmpty() || edPassword.text.trim().isNotEmpty()){
                Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()

            }
            else{

            Toast.makeText(this, "input required", Toast.LENGTH_LONG).show();

        }

        }
            tvRegister.setOnClickListener{
                val intent = Intent( this, RegisterActivity::class.java)
                startActivity(intent)

            }

    }
}

