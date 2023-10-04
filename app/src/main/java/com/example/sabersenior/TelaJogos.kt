package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

import com.example.sabersenior.JogoForca.JogoForca
import android.widget.ImageView


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
            val intent = Intent(this, JogoVelha::class.java)
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
    }
}