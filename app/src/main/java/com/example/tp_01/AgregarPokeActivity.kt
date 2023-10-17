package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class AgregarPokeActivity  : AppCompatActivity(){
    lateinit var toolbar: Toolbar
    lateinit var etNombre: EditText
    lateinit var etTipo: EditText
    lateinit var btnAgregar: Button

    override  fun  onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_poke)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.boton_agregar)

        etNombre = findViewById(R.id.etNombre)
        etTipo = findViewById(R.id.etTipo)
        btnAgregar = findViewById(R.id.btnGuardar)

        btnAgregar.setOnClickListener {
            var nombre = etNombre.text.toString()
            var tipo = etTipo.text.toString()
            if (nombre.isEmpty() || tipo.isEmpty()) {
                Toast.makeText(this, "Es necesario completar los datos", Toast.LENGTH_SHORT).show()
            } else {
                var nuevoPoke = Poke(nombre, tipo)
                AppDatabase.getDatabase(this).PokeDao().insertPoke(nuevoPoke)
                var intentListado = Intent(this, listadoPokeActivity::class.java)
                startActivity(intentListado)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_agregar_poke, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_volver) {
            val intent = Intent(this, listadoPokeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


}