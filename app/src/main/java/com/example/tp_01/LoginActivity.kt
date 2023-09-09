package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var etUser: EditText
    lateinit var etPass: EditText
    lateinit var cbRecordar: CheckBox
    lateinit var btnIniciarSesion: Button
    lateinit var btnRegistrarse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUser = findViewById(R.id.editUser)
        etPass = findViewById(R.id.editPass)
        cbRecordar = findViewById(R.id.cbRecordar)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnRegistrarse = findViewById(R.id.btnRegistrarse)

        var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
        var usuarioGuardado = preferencias.getString(resources.getString(R.string.nombre_usuario), "")
        var passwordGuardado = preferencias.getString(resources.getString(R.string.password_usuario), "")

        //if(usuarioGuardado!= null && passwordGuardado!= null){
         //   startMainActivity(usuarioGuardado)
        //}

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "mis poke"

        /*btnIniciarSesion.setOnClickListener {
            var mensaje = "Iniciar Sesion"

            var nombreUsuario = etUser.text.toString()
            var passWordUsuario = etPass.text.toString()

            if(nombreUsuario.isEmpty() || passWordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje += " - Datos OK"

                if (cbRecordar.isChecked){

                    mensaje += "- Recordar Usuario"

                    var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
                    preferencias.edit().putString(resources.getString(R.string.nombre_usuario), nombreUsuario).apply()
                    preferencias.edit().putString(resources.getString(R.string.password_usuario), passWordUsuario).apply()
            }
         }*/
        btnIniciarSesion.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUser.text.toString()
            if (nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()) {
                mensaje += " - Faltan Datos"
            } else {
                mensaje += " - Datos OK"
                // Verificamos si esta tildado el CechBox
                if (cbRecordar.isChecked)
                    mensaje += "- Recordar Usuario"

                // Indicamos a que pantalla queremos ir
                val intentMain = Intent(this, MainActivity::class.java)
                // Agregamos datos que queremos pasar a la proxima pantalla
                intentMain.putExtra("nombre", nombreUsuario)
                // Cambiamos de pantalla
                startActivity(intentMain)
                // Eliminamos la Activity actual para sacarla de la Pila
                finish()
            }
        }


        btnRegistrarse.setOnClickListener {
            var mensaje = "Iniciar Sesion"

            var nombreUsuario = etUser.text.toString()
            if(nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()){
                mensaje+= " - Faltan Datos"
            }
            val intentMain = Intent(this, RegisterActivity::class.java)
            intentMain.putExtra("nombre", nombreUsuario)
            startActivity(intentMain)
            finish()
        }
    }

    /*private fun startMainActivity(usuarioGuardado: String) {
        // Indicamos a que pantalla queremos ir
        val intentMain = Intent(this, MainActivity::class.java)
        // Agregamos datos que queremos pasar a la proxima pantalla
        intentMain.putExtra(resources.getString(R.string.nombre_usuario), usuarioGuardado)
        // Cambiamos de pantalla
        startActivity(intentMain)
        // Eliminamos la Activity actual para sacarla de la Pila
        finish()
    }

    }*/
    }
