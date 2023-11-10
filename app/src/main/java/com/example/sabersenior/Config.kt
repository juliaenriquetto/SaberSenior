package com.example.sabersenior

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.sabersenior.model.Usuario

class Config : AppCompatActivity() {

    private var currentTheme = R.style.AppTheme_LightTheme // Tema padrão é o tema claro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(currentTheme)
        setContentView(R.layout.activity_config)

        val idUsuario = intent.getIntExtra("idUsuario", -1)
        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val telefoneUsuario = intent.getStringExtra("telefoneUsuario")
        val idFraseSecretaUsuario = intent.getStringExtra("idFraseSecretaUsuario")
        val usuario = Usuario(
            idUsuario,
            idFraseSecretaUsuario ?: "",
            nomeUsuario ?: "",
            telefoneUsuario ?: ""
        )

        val txtNomeConfig = findViewById<TextView>(R.id.txtNomeConfig)
        txtNomeConfig.text = usuario.nome

        // Alert Dialog Btn_SobreNos
        val Sobre = findViewById<Button>(R.id.btnSobre)

        Sobre.setOnClickListener(){
            val dialaogBing = layoutInflater.inflate(R.layout.custom_allert_sobre_nos, null)

            val dialogSobre = Dialog(this)
            dialogSobre.setContentView(dialaogBing)

            dialogSobre.setCancelable(true)
            dialogSobre.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
             dialogSobre.show()
        }


        val ParaQuem = findViewById<Button>(R.id.btnParaQuem)

        ParaQuem.setOnClickListener(){
            val dialaogBing2 = layoutInflater.inflate(R.layout.custtom_allert_para_quem, null)

            val dialogSobre = Dialog(this)
            dialogSobre.setContentView(dialaogBing2)

            dialogSobre.setCancelable(true)
            dialogSobre.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogSobre.show()
        }

        //botão sair da conta
        val btnSair = findViewById<Button>(R.id.btnSairConfig)
        btnSair.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }



        // MENU
        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome   = menu.findViewById<Button>(R.id.btnHome)
        val btnPerfil = menu.findViewById<Button>(R.id.btnPerfil)

        btnConfig.setOnClickListener{
            val intent = Intent(this, Config::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnHome.setOnClickListener{
            val intent = Intent(this, TelaJogos::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
            intent.putExtra("idUsuario", usuario.id)
            intent.putExtra("idFraseSecretaUsuario", usuario.idFraseSecreta)
            intent.putExtra("nomeUsuario", usuario.nome)
            intent.putExtra("telefoneUsuario", usuario.telefone)
            startActivity(intent)
        }
    }
}
