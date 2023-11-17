package com.example.sabersenior.PalavraCruzada

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.sabersenior.R

class PalavraCruzada: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_palavra_cruzada__menu)
    }
}