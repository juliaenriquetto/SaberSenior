package com.example.sabersenior

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Perfil : AppCompatActivity() {

//    fun update(){
//        val retrofitClient = RetrofitConfig.getRetrofit()
//        val service = retrofitClient.create(Service::class.java)
//        val callback = service.alterarUsuario(1); //concertar isso
//
//        callback.enqueue(object : Callback<Usuario> {
//            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
//                Toast.makeText(baseContext, "Nome: ${response!!.body()?.nome}", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
//                println("Erro ao realizar update")
//            }
//        })
//    }

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
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

        }
        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome   = menu.findViewById<Button>(R.id.btnHome)
        val btnPerfil = menu.findViewById<Button>(R.id.btnPerfil)


        btnConfig.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
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

        val salvarButton = findViewById<Button>(R.id.salvarButton)
//        salvarButton.setOnClickListener{update()}
    }
}







