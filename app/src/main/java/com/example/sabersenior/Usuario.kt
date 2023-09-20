package com.example.sabersenior

import com.google.gson.annotations.SerializedName

data class Usuario (
    @SerializedName("id")
    val id: Int,

    @SerializedName("idFraseSecreta")
    val idFraseSecreta: String,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("telefone")
    val telefone: Int
)