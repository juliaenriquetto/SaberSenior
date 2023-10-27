package com.example.sabersenior.JogoMemoria

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.sabersenior.R


class JogoMemoria : AppCompatActivity() {
    private var btn16: Button? = null
    private var btn20: Button? = null
    private var btn24: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_memoria)

        inicializarComponents()
        adicionarOuvintes()
    }

    fun inicializarComponents() {
        btn16 = findViewById(R.id.btn16) as Button
        btn20 = findViewById(R.id.btn20) as Button
        btn24 = findViewById(R.id.btn24) as Button
    }

    fun adicionarOuvintes() {
        btn16!!.setOnClickListener(this)
        btn20!!.setOnClickListener(this)
        btn24!!.setOnClickListener(this)
    }

    fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btn16 -> {
                intent.setClass(this, Activity_16::class.java)
                startActivity(intent)
            }
            R.id.btn20 -> {
                intent.setClass(this, Activity_20::class.java)
                startActivity(intent)
            }
            R.id.btn24 -> {
                intent.setClass(this, Activity_24::class.java)
                startActivity(intent)
            }
        }
    }
}