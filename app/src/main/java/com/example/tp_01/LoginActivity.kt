package com.example.tp_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var etUser: EditText
    lateinit var etPass: EditText
    lateinit var btnIniciarSesion: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUser = findViewById(R.id.editUser)
        etPass = findViewById(R.id.editPass)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
    }
}