package com.maktay.blog.services

import com.maktay.blog.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    fun getApiService(): Services {
        val builder = Retrofit.Builder()
            .baseUrl(Utils.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()
        return builder.create(Services::class.java)
    }
    private fun getOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor())
        return client.build()
    }
}