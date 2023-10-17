package com.example.tp_01

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokes_table")
data class Poke(
    @ColumnInfo(name = "nombre") var nombre:String,
    @ColumnInfo(name = "tipo") var tipo:String
) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}