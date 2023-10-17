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

        val btnedtPerfil = findViewById<Button>(R.id.btnEditarPerfil) // Adicione essa linha

        btnedtPerfil.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun showCustomDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)

        val builder = .Builder(this)
        builder.setView(dialogView)

        val alertDialog = builder.create()

        val nomeEditText = dialogView.findViewById<editText>(R.id.nomeEditText)
        val telefoneEditText = dialogView.findViewById<EditText>(R.id.telefoneEditText)
        val salvarButton = dialogView.findViewById<Button>(R.id.salvarButton)
        val fecharButton = dialogView.findViewById<Button>(R.id.fecharButton)

        salvarButton.setOnClickListener {
            val novoNome = nomeEditText.text.toString()
            val novoTelefone = telefoneEditText.text.toString()

            // Aqui você pode adicionar o código para salvar os dados.

            alertDialog.dismiss()
        }

        fecharButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}

    }
