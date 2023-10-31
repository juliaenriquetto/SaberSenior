package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

import com.example.sabersenior.JogoForca.JogoForca
import android.widget.LinearLayout
import com.example.sabersenior.model.Usuario

//import com.example.sabersenior.JogoVelha.JogoVelha


class TelaJogos : AppCompatActivity() {
    lateinit var btnJogoDaForca: ImageButton
    lateinit var btnJogoDaVelha: ImageButton
    lateinit var btnPalavraCruzada: ImageButton
    lateinit var btnSudoku: ImageButton
    lateinit var btnCacaPalavra: ImageButton
    lateinit var btnMemoria: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_jogos)

        btnJogoDaForca = findViewById(R.id.btnJogoDaForca)
        btnJogoDaVelha = findViewById(R.id.btnJogoDaVelha)
        btnPalavraCruzada = findViewById(R.id.btnPalavraCruzada)
        btnSudoku = findViewById(R.id.btnSudoku)
        btnCacaPalavra = findViewById(R.id.btnCacaPalavra)
        btnMemoria = findViewById(R.id.btnMemoria)

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

        btnJogoDaForca.setOnClickListener{
            val intent = Intent(this, JogoForca::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnJogoDaVelha.setOnClickListener{
//            val intent = Intent(this, JogoVelha::class.java)
            startActivity(intent)
        }

        btnPalavraCruzada.setOnClickListener{
            val intent = Intent(this, JogoPalavraCruzada::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnSudoku.setOnClickListener{
            val intent = Intent(this, JogoSudoku::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnCacaPalavra.setOnClickListener{
            val intent = Intent(this, JogoCacaPalavra::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnMemoria.setOnClickListener{
            val intent = Intent(this, JogoMemoria::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnJogoDaVelha.setImageResource(R.drawable.jododavelha)
        btnPalavraCruzada.setImageResource(R.drawable.palavracruzada)
        btnCacaPalavra.setImageResource(R.drawable.cacapalavra)
        btnMemoria.setImageResource(R.drawable.jogomemoria)

        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome = menu.findViewById<Button>(R.id.btnHome)
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