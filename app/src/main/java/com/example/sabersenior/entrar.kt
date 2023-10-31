package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class entrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrar)

        lateinit var btnC: MaterialButton

        btnC = findViewById(R.id.btnCadasTela)

        btnC.setOnClickListener()
        {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }


    }
}