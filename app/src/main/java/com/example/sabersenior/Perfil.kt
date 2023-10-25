package com.example.sabersenior

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import com.example.sabersenior.model.CadastroUsuario
import com.example.sabersenior.model.Usuario
import retrofit2.Call
import retrofit2.Callback


class Perfil : AppCompatActivity() {

    //metodo para atualizar
    fun update(usuario: Usuario){
        val retrofitClient = RetrofitConfig.getRetrofit()
        val service = retrofitClient.create(Service::class.java)

        val usuarioAlterado = CadastroUsuario(usuario.nome, usuario.telefone, usuario.idFraseSecreta)
        val callback = service.alterarUsuario(usuario.id, usuarioAlterado)

        callback.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: retrofit2.Response<Usuario>?) {
                Toast.makeText(baseContext, "Usuário atualizado!", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                Toast.makeText(baseContext, "Erro ao realizar update", Toast.LENGTH_LONG).show()
                println("Erro ao realizar update")
                println(t.toString())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setImageResource(R.drawable.imagemteste)

        val idUsuario = intent.getIntExtra("idUsuario", -1)
        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val telefoneUsuario = intent.getStringExtra("telefoneUsuario")
        val idFraseSecretaUsuario = intent.getStringExtra("idFraseSecretaUsuario")
        val usuario = Usuario(
            idUsuario,
            idFraseSecretaUsuario ?: "",
            nomeUsuario ?: "",
            telefoneUsuario ?: ""
        )

        val textViewNome = findViewById<TextView>(R.id.tv_nome_usuario)
        textViewNome.text = usuario.nome

        val btnedit = findViewById<Button>(R.id.btnEditarPerfil)

        btnedit.setOnClickListener {
            val myDialog = Dialog(this)
            myDialog.setContentView(R.layout.editerfil)

            val nomeEditText = myDialog.findViewById<EditText>(R.id.EdtNomePf)
            val telefoneEditText = myDialog.findViewById<EditText>(R.id.EdtTelPf)

            nomeEditText.setText(usuario.nome)
            telefoneEditText.setText(usuario.telefone)

            val Sairedit = myDialog.findViewById<Button>(R.id.editcancelar)

            Sairedit.setOnClickListener {
                myDialog.dismiss()
            }

            val salvarButton = myDialog.findViewById<Button>(R.id.salvar)
            salvarButton.setOnClickListener {
                usuario.nome = nomeEditText.text.toString()
                usuario.telefone = telefoneEditText.text.toString()
                update(usuario)
                myDialog.dismiss()
                textViewNome.text = usuario.nome
            }

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()
        }

        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome   = menu.findViewById<Button>(R.id.btnHome)
        val btnPerfil = menu.findViewById<Button>(R.id.btnPerfil)

        btnConfig.setOnClickListener{
            val intent = Intent(this, Config::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnHome.setOnClickListener{
            val intent = Intent(this, TelaJogos::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }
    }

}


