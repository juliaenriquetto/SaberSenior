package com.example.sabersenior

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT

interface Service {
    //CRUD

    @GET("/api/usuario/get/")
    fun getUsuario(): Call<List<Usuario>>

    @GET("/api/usuario/getId/{id}")
    fun selecionarUsuario(): Call<List<Usuario>>

    @POST("/api/usuario/post")
    fun incluirUsuario(id:Int, usuario:Usuario): Call<List<Usuario>>

    @PUT("/api/usuario/put/{id}")
    fun alterarUsuario(id:Int, usuario:Usuario): Call<List<Usuario>>

    @DELETE("/api/usuario/delete/{id}")
    fun excluirUsuario(id:Int, usuario:Usuario): Call<Usuario>
}