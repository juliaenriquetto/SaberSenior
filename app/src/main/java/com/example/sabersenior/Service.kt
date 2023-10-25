package com.example.sabersenior

import com.example.sabersenior.model.CadastroUsuario
import com.example.sabersenior.model.Usuario
import retrofit2.Call
import retrofit2.http.*


interface Service {
    @GET("/api/Cadastro/")
    fun getUsuario(): Call<List<Usuario>>

    @GET("/api/Cadastro/{id}")
    fun selecionarUsuario(): Call<List<Usuario>>

    @Headers("Content-Type: application/json")
    @POST("/api/Cadastro/")
    fun incluirUsuario(@Body cadastroUsuario: CadastroUsuario): Call<Usuario>

    @Headers("Content-Type: application/json")
    @PUT("/api/Cadastro/{id}")
    fun alterarUsuario(id: Int, @Body cadastroUsuario: CadastroUsuario): Call<Usuario>

    @DELETE("/api/Cadastro/{id}")
    fun excluirUsuario(id: Int): Call<Usuario>
}