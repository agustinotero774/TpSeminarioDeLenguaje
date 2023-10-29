package com.example.tp_01

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Query("select * from usuarios_tabla")
    fun getAll(): List<Usuario>

    @Query("select * from usuarios_tabla where nombre = :nombreAux")
    fun getNombre(nombreAux: String): Usuario

    @Insert
    fun insertUsuario(usuario: Usuario)

}