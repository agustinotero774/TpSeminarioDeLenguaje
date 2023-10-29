package com.example.tp_01

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Poke::class,Usuario::class], version = 1)

abstract class AppDatabase:RoomDatabase() {


    abstract fun PokeDao(): PokeDao
    //abstract fun usuarioDao(): UsuarioDao
    abstract val usuarioDao:UsuarioDao
    companion object{

        private var INSTANCIA: AppDatabase?= null

        fun getDatabase(contexto: Context) : AppDatabase{
            if(INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                        contexto, AppDatabase::class.java, "base_app")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                    var instancia = INSTANCIA
                    if (instancia == null) {
                        instancia = Room.databaseBuilder(
                            contexto, AppDatabase::class.java, "base_app_usuarios"
                        ).allowMainThreadQueries().build()
                        INSTANCIA = instancia
                    }
                    return instancia
                }
            }
            return INSTANCIA!!
        }


    }



}
