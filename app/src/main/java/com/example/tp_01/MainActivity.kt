package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

lateinit var toolbar: Toolbar
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        saludarUsuario()

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Pokeland"
    }


    private fun saludarUsuario() {
        // Obtengo los datos que me mandaron
        var bundle: Bundle? = intent.extras
        // Reviso que efectivamente tenga datos
        if(bundle != null){
            // Obtengo el dato especifico
            var usuario = bundle?.getString(resources.getString(R.string.nombre_usuario))
            // Muestro el mensaje
            Toast.makeText(this, "Bienvenido/a $usuario", Toast.LENGTH_SHORT).show()
        }
    }

}