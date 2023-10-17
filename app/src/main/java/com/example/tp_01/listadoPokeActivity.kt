package com.example.tp_01


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView

class listadoPokeActivity : AppCompatActivity() {
    lateinit var rvPoke: RecyclerView
    lateinit var pokeAdapter : PokeAdapter
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_poke)

        rvPoke= findViewById(R.id.rvPoke)
        pokeAdapter = PokeAdapter(getPoke(), this)
        rvPoke.adapter = pokeAdapter

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listado, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_agregar){
            val intentAgregar = Intent(this, AgregarPokeActivity::class.java)
            startActivity(intentAgregar)
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getPoke(): MutableList<Poke> {
        var poke: MutableList<Poke> = ArrayList()
        var bdd = AppDatabase.getDatabase(this)
        poke.addAll(bdd.PokeDao().getAll())
        poke.add(Poke("pikachu","electrico"))
        poke.add(Poke("eevi","normal"))
        poke.add(Poke("umbreon","oscuro"))
        poke.add(Poke("vaporeon","agua"))

        return poke

    }
}