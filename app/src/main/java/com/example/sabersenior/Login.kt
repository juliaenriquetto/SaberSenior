package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Login : AppCompatActivity() {
    lateinit var edtNome: EditText
    lateinit var edtTelefone: EditText
    lateinit var edtFraseSecreta: EditText
    lateinit var btnLogin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtNome = findViewById(R.id.edtNome)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtFraseSecreta = findViewById(R.id.edtFraseSecreta)

        btnLogin.setOnClickListener{
            var usuario = Usuario()

            usuario.idFraseSecreta = edtFraseSecreta.text.toString()
            usuario.nome = edtNome.text.toString()
            usuario.telefone = edtTelefone.text.toString()

            val intent = Intent(this, TelaJogos::class.java)
            startActivity(intent)
        }
    }
}