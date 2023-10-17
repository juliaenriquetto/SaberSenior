package com.example.sabersenior

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setImageResource(R.drawable.imagemteste)

        val btnedit = findViewById<Button>(R.id.btnEditarPerfil)

        btnedit.setOnClickListener {
            val myDialog = Dialog(this)
            myDialog.setContentView(R.layout.editerfil)

            val Sairedit = myDialog.findViewById<Button>(R.id.editcancelar)

            Sairedit.setOnClickListener {
                myDialog.dismiss()
            }

            myDialog.show()
        }
    }


}




