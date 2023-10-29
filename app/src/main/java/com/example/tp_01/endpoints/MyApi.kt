package com.example.tp_01.endpoints

import com.example.tp_01.dtos.Post
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MyApi {

    @GET("/post")
    fun getPost() : Call<List<Post>>

}