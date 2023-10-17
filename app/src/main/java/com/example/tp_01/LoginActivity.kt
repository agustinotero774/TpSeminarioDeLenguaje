package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {


    lateinit var etUser: EditText
    lateinit var etPass: EditText
    lateinit var cbRecordar: CheckBox
    lateinit var btnRegistrarse: Button
    lateinit var btnIniciarSesion: Button
    lateinit var toolbar: Toolbar


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

        if(usuarioGuardado!= null && passwordGuardado!= null){
            startMainActivity(usuarioGuardado)
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)


        btnRegistrarse.setOnClickListener {
            // Mostramos un mensaje
            //Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show()
            var intentTerminos = Intent(this, TerminosYCondicionesActivity::class.java)
            startActivity(intentTerminos)
        }


        btnIniciarSesion.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            var nombreUsuario = etUser.text.toString()
            var passwordUsuario = etPass.text.toString()
            if(nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"

                if(cbRecordar.isChecked) {
                    var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
                    preferencias.edit().putString(resources.getString(R.string.nombre_usuario), nombreUsuario).apply()
                    preferencias.edit().putString(resources.getString(R.string.password_usuario), passwordUsuario).apply()
                }
                startMainActivity(nombreUsuario)
            }
        }
    }

    private fun startMainActivity(usuarioGuardado: String) {
        val intentMain = Intent(this, MainActivity::class.java)
        intentMain.putExtra(resources.getString(R.string.nombre_usuario), usuarioGuardado)
        startActivity(intentMain)
        finish()
    }
}