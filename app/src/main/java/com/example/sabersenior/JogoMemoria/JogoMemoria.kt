package com.example.sabersenior.JogoMemoria

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import com.example.sabersenior.R
import java.util.*

class JogoMemoria: AppCompatActivity() {
    private var cartasViradas = 0 // VERIFICA QUANTAS CARTAS ESTÃO VIRADAS AO MESMO TEMPO
    private var pontos = 0

    private lateinit var primeiraCartaVirada: ImageButton
    private lateinit var segundaCartaVirada: ImageButton
    private lateinit var btn0: ImageButton
    private lateinit var btn1: ImageButton
    private lateinit var btn2: ImageButton
    private lateinit var btn3: ImageButton
    private lateinit var btn4: ImageButton
    private lateinit var btn5: ImageButton
    private lateinit var btn6: ImageButton
    private lateinit var btn7: ImageButton
    private lateinit var btn8: ImageButton
    private lateinit var btn9: ImageButton
    private lateinit var btn10: ImageButton
    private lateinit var btn11: ImageButton
    private lateinit var btn12: ImageButton
    private lateinit var btn13: ImageButton
    private lateinit var btn14: ImageButton
    private lateinit var btn15: ImageButton
    private lateinit var btn16: ImageButton
    private lateinit var btn17: ImageButton
    private lateinit var btn18: ImageButton
    private lateinit var btn19: ImageButton
    private lateinit var btn20: ImageButton
    private lateinit var btn21: ImageButton
    private lateinit var btn22: ImageButton
    private lateinit var btn23: ImageButton
    private lateinit var txtPontos: TextView

    private val batman = R.drawable.abacaxi
    private val huck = R.drawable.banana
    private val rangerAzul = R.drawable.beterraba
    private val goku = R.drawable.caqui
    private val incrivel = R.drawable.cereja
    private val sonic = R.drawable.framboesa
    private val mario = R.drawable.kiwi
    private val volverine = R.drawable.laranja
    private val mulhergata = R.drawable.limao
    private val aranha = R.drawable.maca
    private val freeza = R.drawable.melancia
    private val luigi = R.drawable.uva

    private lateinit var botoes: Array<ImageButton>
    private lateinit var imagens: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_24)

        inicializarComponents()
        inicializarArrays()
        mostrarCartas()
        esconderTodos()
    }

    private fun inicializarComponents() {
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn10 = findViewById(R.id.btn10)
        btn11 = findViewById(R.id.btn11)
        btn12 = findViewById(R.id.btn12)
        btn13 = findViewById(R.id.btn13)
        btn14 = findViewById(R.id.btn14)
        btn15 = findViewById(R.id.btn15)
        btn16 = findViewById(R.id.btn16)
        btn17 = findViewById(R.id.btn17)
        btn18 = findViewById(R.id.btn18)
        btn19 = findViewById(R.id.btn19)
        btn20 = findViewById(R.id.btn20)
        btn21 = findViewById(R.id.btn21)
        btn22 = findViewById(R.id.btn22)
        btn23 = findViewById(R.id.btn23)
        txtPontos = findViewById(R.id.txtPontos)
    }

    private fun inicializarArrays() {
        botoes = arrayOf(
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,
            btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15,
            btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23
        )

        imagens = intArrayOf(
            batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
            batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
            mulhergata, aranha, freeza, luigi, mulhergata, aranha, freeza, luigi
        )
    }

    private fun mostrarCartas() {
        imagens.shuffle()
        botoes.shuffle()

        for (i in botoes.indices) {
            botoes[i].setBackgroundResource(imagens[i])
        }
    }

    private fun esconderTodos() {
        for (botao in botoes) {
            botao.setImageResource(R.drawable.esconde)
        }
    }

    fun onClick(v: View) {
        val cartaTocada = v as ImageButton

        if (cartasViradas == 0) {
            primeiraCartaVirada = cartaTocada
            viraCarta(cartaTocada)
            cartasViradas = 1
            primeiraCartaVirada.isClickable = false

        } else {
            segundaCartaVirada = cartaTocada
            cartasViradas = 0
            viraCarta(segundaCartaVirada)
            segundaCartaVirada.isClickable = false

            if (verificaCartas(primeiraCartaVirada, segundaCartaVirada)) {
                pontos++
                verificarPlacar()
            } else {
                pontos--
                verificarPlacar()
                desvirarCartas(primeiraCartaVirada, segundaCartaVirada)
                primeiraCartaVirada.isClickable = true
                segundaCartaVirada.isClickable = true
            }
        }
    }

    private fun viraCarta(cartaTocada: ImageButton) {
        cartaTocada.setImageResource(0)
    }

    private fun verificarPlacar() {
        when {
            pontos > 0 -> txtPontos.setTextColor(Color.rgb(0, 14, 0))
            pontos == 0 -> txtPontos.setTextColor(Color.rgb(14, 14, 14))
            else -> txtPontos.setTextColor(Color.rgb(14, 0, 0))
        }

        txtPontos.text = "Pontos: $pontos"
    }

    private fun verificaCartas(carta1: ImageButton, carta2: ImageButton): Boolean {
        return carta1.background.constantState == carta2.background.constantState
    }

    private fun desvirarCartas(carta1: ImageButton, carta2: ImageButton) {
        carta1.setImageResource(R.drawable.esconde)
        carta2.setImageResource(R.drawable.esconde)
    }
}