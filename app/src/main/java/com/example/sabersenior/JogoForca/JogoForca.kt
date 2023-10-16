package com.example.sabersenior.JogoForca

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sabersenior.R
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class JogoForca : AppCompatActivity() {
    private lateinit var fachada: Fachada
    private lateinit var tvdica: TextView
    private lateinit var tvpalavra: TextView
    private lateinit var tvinfos: TextView
    private lateinit var botaozinho: Button
    private lateinit var entrada: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_forca)

        this.fachada = Fachada()
        fachada.Padrao()
        fachada.start()

        this.tvdica = findViewById(R.id.tvDica)
        this.tvdica.text = fachada.diquinha()

        tvpalavra = findViewById(R.id.textViewPalavra)
        this.tvpalavra.text = fachada.palavrota()

        tvinfos = findViewById(R.id.textViewinfos)
        tvinfos.text = fachada.infos()

        botaozinho = findViewById(R.id.clicador)

        entrada = findViewById(R.id.TextEntrada)

        botaozinho.setOnClickListener(cliqueBotao())
    }

    inner class cliqueBotao: View.OnClickListener {
        override fun onClick(p0: View?) {
            if (this@JogoForca.fachada.terminou()) {
                this@JogoForca.botaozinho.isEnabled = false
            }
            this@JogoForca.fachada.jogar(this@JogoForca.entrada.text.toString())
            this@JogoForca.tvpalavra.text = this@JogoForca.fachada.palavrota()
            this@JogoForca.tvinfos.text = this@JogoForca.fachada.infos()
        }
    }
}