package com.example.tp_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.core.content.ContextCompat
import com.example.tp_01.configurations.RetroFitClient
import com.example.tp_01.dtos.Post
import com.example.tp_01.endpoints.MyApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.create

lateinit var toolbar: Toolbar
class MainActivity : AppCompatActivity() {

    private lateinit var tvServicioRest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saludarUsuario()


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Mis Pokemones"


        findViewById<View>(R.id.btnIniciarServicio).setOnClickListener(){
            val intent = Intent(this,ServicioMusica::class.java)
            intent.putExtra("pause",true)
            ContextCompat.startForegroundService(this, intent)
        }

        findViewById<View>(R.id.btnStop).setOnClickListener(){
            val intent = Intent(this,ServicioMusica::class.java)
            stopService(intent)
        }

        val api = RetroFitClient.retrofit.create(MyApi::class.java)
        val callPost = api.getPost()

        callPost.enqueue(object : retrofit2.Callback<List<Post>>
        {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val post = response.body()
                if(post != null){
                    tvServicioRest = findViewById(R.id.tvServicioRest)
                    tvServicioRest.text = post.toString()
                    Log.d("respuesta",post.toString())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
               Log.e("error",t.message?:"")
            }
        })

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