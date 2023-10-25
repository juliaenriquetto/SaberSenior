package com.example.sabersenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener{
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }
    }

    //endereco da API node

    val retrofitClient = RetrofitConfig.getRetrofit()
    //rotas http da api
    val service = retrofitClient.create(Service::class.java)
    val callback = service.getUsuario()

}