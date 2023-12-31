package com.example.sabersenior

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.sabersenior.model.Usuario
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class entrar : AppCompatActivity() {

    lateinit var btnCadastro: MaterialButton
    lateinit var edtTelefone: EditText
    lateinit var edtFraseSecreta: EditText
    lateinit var btnEntrar: MaterialButton

    fun entrar(){
        val retrofitClient = RetrofitConfig.getRetrofit()
        val service = retrofitClient.create(Service::class.java)

        val callback = service.logarUsuario(edtTelefone.text.toString(), edtFraseSecreta.text.toString())

        val intent = Intent(this, TelaJogos::class.java)

        callback.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                println(response)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val usuario = Usuario(responseBody.id, responseBody.idFraseSecreta, responseBody.nome, responseBody.telefone)
                        intent.putExtra("idUsuario", usuario.id)
                        intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
                        intent.putExtra("nomeUsuario", usuario.nome)
                        intent.putExtra("telefoneUsuario", usuario.telefone)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(baseContext, "Credenciais inválidas!", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(baseContext, "Credenciais inválidas!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(baseContext, "Erro ao realizar login", Toast.LENGTH_LONG).show()
                println("Erro ao realizar login")
                println(t.toString())
            }
        })
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrar)

        val retrofitClient = RetrofitConfig.getRetrofit()
        val service = retrofitClient.create(Service::class.java)

        service.getUsuario();

        btnCadastro = findViewById(R.id.btnCadasTela)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtFraseSecreta = findViewById(R.id.edtFraseSecreta)
        btnEntrar = findViewById(R.id.btnEntrar)

        btnEntrar.setOnClickListener() {
            entrar()
        }

        btnCadastro.setOnClickListener()
        {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

    }
}