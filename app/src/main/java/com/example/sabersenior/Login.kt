package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    lateinit var edtNome: EditText
    lateinit var edtTelefone: EditText
    lateinit var edtFraseSecreta: EditText
    lateinit var btnLogin: EditText

    fun login(){
        val retrofitClient = RetrofitConfig.getRetrofit()
        val service = retrofitClient.create(Service::class.java)
        val callback = service.incluirUsuario(edtNome.text.toString(), edtTelefone.text.toString(), edtFraseSecreta.text.toString())

        callback.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                Toast.makeText(baseContext, "Nome: ${response!!.body()?.nome}", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                println("Erro ao realizar login")
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtNome = findViewById(R.id.edtNome)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtFraseSecreta = findViewById(R.id.edtFraseSecreta)

        btnLogin.setOnClickListener{login()}

        /*
        val idFraseSecreta = edtFraseSecreta.text.toString()
        val nome = edtNome.text.toString()
        val telefone = edtTelefone.text.toString()


        var usuario = Usuario(15, idFraseSecreta, nome, telefone)
        val intent = Intent(this, TelaJogos::class.java)
        startActivity(intent)

      */
    }
}