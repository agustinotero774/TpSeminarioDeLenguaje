package com.example.tp_01

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "usuarios_tabla")
data class Usuario(
    @ColumnInfo(name = "nombre") var nombre: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "contra") var contra: String)
{
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}