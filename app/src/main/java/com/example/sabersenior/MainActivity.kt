package com.example.sabersenior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //endereco da API node
    val retrofitClient = RetrofitConfig.getRetrofit()
    //rotas http da api
    val service = retrofitClient.create(Service::class.java)
    val callback = service.getUsuario()

}