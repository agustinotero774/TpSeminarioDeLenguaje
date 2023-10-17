package com.example.tp_01

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokeDao {
    @Query("select * from pokes_table")
    fun getAll(): List<Poke>

    @Insert
    fun insertPoke(poke: Poke)
}