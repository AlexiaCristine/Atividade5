package com.example.atividade5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {

            if (editUsername.text.trim().isNotEmpty() || editPassword.text.trim()
                    .isNotEmpty() || editCPassword.text.trim().isNotEmpty()
            ) {
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
}