package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import android.widget.ImageButton

import com.example.sabersenior.JogoForca.JogoForca
import android.widget.ImageView
import android.widget.LinearLayout

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

        btnJogoDaForca.setOnClickListener{
            val intent = Intent(this, JogoForca::class.java)
            startActivity(intent)
        }

        btnJogoDaVelha.setOnClickListener{
//            val intent = Intent(this, JogoVelha::class.java)
            startActivity(intent)
        }

        btnPalavraCruzada.setOnClickListener{
            val intent = Intent(this, JogoPalavraCruzada::class.java)
            startActivity(intent)
        }

        btnSudoku.setOnClickListener{
            val intent = Intent(this, JogoSudoku::class.java)
            startActivity(intent)
        }

        btnCacaPalavra.setOnClickListener{
            val intent = Intent(this, JogoCacaPalavra::class.java)
            startActivity(intent)
        }

        btnMemoria.setOnClickListener{
            val intent = Intent(this, JogoMemoria::class.java)
            startActivity(intent)
        }

        btnJogoDaVelha.setImageResource(R.drawable.jododavelha)
        btnPalavraCruzada.setImageResource(R.drawable.palavracruzada)
        btnCacaPalavra.setImageResource(R.drawable.cacapalavra)
        btnMemoria.setImageResource(R.drawable.jogomemoria)

        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome   = menu.findViewById<Button>(R.id.btnHome)
        val btnPerfil = menu.findViewById<Button>(R.id.btnPerfil)

        btnConfig.setOnClickListener{
            val intent = Intent(this, Config::class.java)
            startActivity(intent)
        }

        btnHome.setOnClickListener{
            val intent = Intent(this, TelaJogos::class.java)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
    }
}