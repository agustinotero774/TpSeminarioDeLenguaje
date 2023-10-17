package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

lateinit var toolbar: Toolbar
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saludarUsuario()


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Mis Pokemones"


        /*findViewById<View>(R.id.btnIniciarServicio).setOnClickListener(){
            val intent = Intent(this,ServicioMusica::class.java)
            intent.putExtra("pause",true)
            ContextCompat.startForegroundService(this,intent)
        }

        findViewById<View>(R.id.btnStop).setOnClickListener(){
            val intent = Intent(this,ServicioMusica::class.java)
            stopService(intent)
        }*/
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_listado){
            val intentListado = Intent(this, listadoPokeActivity::class.java)
            startActivity(intentListado)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saludarUsuario() {
        var bundle: Bundle? = intent.extras
        if(bundle != null){
            var usuario = bundle?.getString(resources.getString(R.string.nombre_usuario))
            Toast.makeText(this, "Bienvenido/a $usuario", Toast.LENGTH_SHORT).show()
        }
    }

}