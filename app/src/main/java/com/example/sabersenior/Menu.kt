package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

class Menu : AppCompatActivity() {
    lateinit var btnConfig: Button
    lateinit var btnHome: Button
    lateinit var btnPerfil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnConfig = findViewById<Button>(R.id.btnConfig)
        btnHome   = findViewById<Button>(R.id.btnHome)
        btnPerfil = findViewById<Button>(R.id.btnPerfil)


        btnConfig.setOnClickListener{
            println("botao config click")
            val intent = Intent(this, Perfil::class.java)
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