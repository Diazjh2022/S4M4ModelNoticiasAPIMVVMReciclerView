package com.example.s4m4modelnoticiasapimvvmreciclerview.repository.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiasAPIService {


    @GET("news?access_key=56475ef4ddfef8323a708a04f614c801&countries=cl")
    fun obtenerNoticias(@Query("languages") languages: String): Call<Noticias>

    @GET("news?access_key=56475ef4ddfef8323a708a04f614c801&sources=cnn")
    fun obtenerCnn(@Query("languages") languages: String): Call<Noticias>

    @GET("news?access_key=56475ef4ddfef8323a708a04f614c801&sources=bbc")
    fun obtenerBbc(@Query("languages") languages: String): Call<Noticias>

    @GET("news?access_key=56475ef4ddfef8323a708a04f614c801&sources=sports")
    fun obtenerDeportes(@Query("languages") languages: String): Call<Noticias>



}