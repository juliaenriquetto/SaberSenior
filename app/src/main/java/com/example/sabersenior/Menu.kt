package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Menu : AppCompatActivity() {
    lateinit var btnConfig: ImageButton
    lateinit var btnHome: ImageButton
    lateinit var btnPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnConfig = findViewById(R.id.btnConfig)
        btnHome = findViewById(R.id.btnHome)
        btnPerfil = findViewById(R.id.btnPerfil)

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