package com.example.s4m4modelnoticiasapimvvmreciclerview.repository.interactor

import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.retrofit.Noticias
import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.retrofit.NoticiasAPIService
import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.retrofit.RestEngine
import retrofit2.Call

class NoticiasInteractor {

    fun traerRespuesta(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }

    fun traerRespuestacnn(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerCnn(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }

    fun traerRespuestabbc(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerBbc(languages)
        val p: Noticias? = resultado.execute().body()

        return p

    }
    fun traerRespuestadeportes(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerDeportes(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }
}