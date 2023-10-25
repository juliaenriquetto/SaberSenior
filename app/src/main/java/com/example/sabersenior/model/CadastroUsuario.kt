package com.example.sabersenior.model

import com.google.gson.annotations.SerializedName

data class CadastroUsuario(
    @SerializedName("nome")
    val nome: String,
    @SerializedName("telefone")
    val telefone: String,
    @SerializedName("idFraseSecreta")
    val idFraseSecreta: String
)
