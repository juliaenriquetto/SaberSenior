package com.example.sabersenior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Perfil : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setImageResource(R.drawable.imagemteste)


    }
}