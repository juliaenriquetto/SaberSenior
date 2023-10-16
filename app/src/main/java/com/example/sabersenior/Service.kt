package com.example.sabersenior

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface Service {
    //CRUD

    @GET("/api/usuario/get/")
    fun getUsuario(): Call<List<Usuario>>


    @GET("/api/usuario/getId/{id}")
    fun selecionarUsuario(): Call<List<Usuario>>

    //authenticate
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/api/usuario/post")
    fun incluirUsuario(nome: String,telefone: String, idFraseSecreta: String): Call<Usuario>

    @PUT("/api/usuario/put/{id}")
    fun alterarUsuario(id:Int, usuario:Usuario): Call<List<Usuario>>

    @DELETE("/api/usuario/delete/{id}")
    fun excluirUsuario(id:Int, usuario:Usuario): Call<Usuario>
}