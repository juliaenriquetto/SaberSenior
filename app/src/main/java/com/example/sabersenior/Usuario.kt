package com.example.sabersenior

import com.google.gson.annotations.SerializedName

data class Usuario (
    @SerializedName("id")
    var id: Int,

    @SerializedName("idFraseSecreta")
    var idFraseSecreta: String,

    @SerializedName("nome")
    var nome: String,

    @SerializedName("telefone")
    var telefone: String
)