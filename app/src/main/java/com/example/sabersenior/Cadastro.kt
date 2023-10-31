package com.example.sabersenior

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.sabersenior.model.CadastroUsuario
import com.example.sabersenior.model.Usuario
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Cadastro : AppCompatActivity() {
    lateinit var edtNome: EditText
    lateinit var edtTelefone: EditText
    lateinit var edtFraseSecreta: EditText
    lateinit var btnLogin: MaterialButton
    lateinit var btnE: MaterialButton

    fun cadastrar(){
        val retrofitClient = RetrofitConfig.getRetrofit()
        val service = retrofitClient.create(Service::class.java)

        val cadastroUsuario = CadastroUsuario(edtNome.text.toString(), edtTelefone.text.toString(), edtFraseSecreta.text.toString())
        val callback = service.incluirUsuario(cadastroUsuario)

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
        setContentView(R.layout.activity_cadastro)

        edtNome = findViewById(R.id.edtNome)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtFraseSecreta = findViewById(R.id.edtFraseSecreta)
        btnLogin = findViewById(R.id.btnCadastro)
        btnE = findViewById(R.id.btnCadasTela)

        btnLogin.setOnClickListener{
            cadastrar()
        }

        btnE.setOnClickListener()
        {
            val intent = Intent(this, entrar::class.java)
            startActivity(intent)
        }

    }
}
