package com.maishameds.post.repository

import com.maishameds.post.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun posts(): Call<List<Post>>

}
