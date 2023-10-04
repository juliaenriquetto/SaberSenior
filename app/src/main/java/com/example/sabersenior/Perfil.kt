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

        //botão que chama o Alert Dialog
        val btnedtPerfil = findViewById<Button>(R.id.btnEditarPerfil)

        btnedtPerfil.setOnClickListener()
        {
            val EdtPerfil = layoutInflater.inflate(R.layout.editerfil, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(EdtPerfil)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val Cancel = EdtPerfil.findViewById<Button>(R.id.cancelar)

            Cancel.setOnClickListener()
            {
                myDialog.dismiss()
            }

        }

    }
    }
