package com.example.sabersenior

import com.example.sabersenior.model.CadastroUsuario
import com.example.sabersenior.model.Usuario
import retrofit2.Call
import retrofit2.http.*


interface Service {
    @GET("/api/Cadastro/")
    fun getUsuario(): Call<List<Usuario>>

    @GET("/api/Cadastro/{id}")
    fun selecionarUsuario(@Body cadastroUsuario: CadastroUsuario): Call<Usuario>

    @Headers("Content-Type: application/json")
    @POST("/api/Cadastro/")
    fun incluirUsuario(@Body cadastroUsuario: CadastroUsuario): Call<Usuario>

    @Headers("Content-Type: application/json")
    @PUT("/api/Cadastro/{id}")
    fun alterarUsuario(@Path("id") id: Int, @Body cadastroUsuario: CadastroUsuario): Call<Usuario>

    @DELETE("/api/Cadastro/{id}")
    fun excluirUsuario(@Path("id") id: Int): Call<Usuario>

    @FormUrlEncoded
    @POST("/api/Cadastro/login")
    fun logarUsuario(@Field("telefone") telefone: String, @Field("idFraseSecreta") idFraseSecreta: String): Call<Usuario>
}