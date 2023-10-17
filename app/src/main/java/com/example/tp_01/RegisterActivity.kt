package com.example.tp_01
/*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    lateinit var etUser: EditText
    lateinit var etEmail:EditText
    lateinit var etPass: EditText
    lateinit var etContrasenia:EditText
    lateinit var btnRegistrarse:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUser = findViewById(R.id.editUser)
        etEmail = findViewById(R.id.editEmail)
        etPass = findViewById(R.id.editPass)
        etContrasenia = findViewById(R.id.editcontrasenia)
        btnRegistrarse = findViewById(R.id.btnRegistrarse)


        btnRegistrarse.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            var nombreUsuario = etUser.text.toString()
            if(nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()){
                mensaje+= " - Faltan Datos"
            }
                val intentMain = Intent(this, LoginActivity::class.java)
                intentMain.putExtra("nombre", nombreUsuario)
                startActivity(intentMain)
                finish()
            }
        }



    }*/
