package com.maktay.blog.services

import com.maktay.blog.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface Services {

    @GET("/posts")
    fun getPosts() : Call<List<Post>>
}