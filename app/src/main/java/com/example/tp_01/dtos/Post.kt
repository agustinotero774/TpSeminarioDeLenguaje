package com.example.tp_01.dtos

import android.icu.text.CaseMap.Title
import android.security.identity.AccessControlProfileId
import com.squareup.moshi.JsonClass
import retrofit2.http.Body

@JsonClass(generateAdapter = true)
data class Post(
    var id:Int,
    var title: String,
    var body: String,
    var userId: Int,
)
