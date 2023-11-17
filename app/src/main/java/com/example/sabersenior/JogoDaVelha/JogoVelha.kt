package com.example.sabersenior.JogoDaVelha

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sabersenior.R

class JogoVelha: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_jogo_velha)
        GameVelha(this, R.layout.activity_jogo_velha)
    }
}