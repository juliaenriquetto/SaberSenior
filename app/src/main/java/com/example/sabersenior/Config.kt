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

class Config : AppCompatActivity() {

    private var currentTheme = R.style.AppTheme_LightTheme // Tema padrão é o tema claro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(currentTheme)
        setContentView(R.layout.activity_config)

        // Alert Dialog Btn_SobreNos
        val btnSobreNos = findViewById<Button>(R.id.btnSobre)

        btnSobreNos.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.custom_allert_sobre_nos, null)
            val RadiusP = layoutInflater.inflate(R.layout.dialog_mudtema, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val radioGroup = RadiusP.findViewById<RadioGroup>(R.id.radioGroup)
            val radioLight = RadiusP.findViewById<RadioButton>(R.id.radioLight)
            val radioDark = RadiusP.findViewById<RadioButton>(R.id.radioDark)

            // Configure os RadioButtons para refletir o tema atual
            if (currentTheme == R.style.AppTheme_LightTheme) {
                radioLight.isChecked = true
            } else {
                radioDark.isChecked = true
            }

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.radioLight -> {
                        currentTheme = R.style.AppTheme_LightTheme
                        setTheme(currentTheme)
                        recreate() // Reinicie a atividade para aplicar o novo tema
                    }
                    R.id.radioDark -> {
                        currentTheme = R.style.AppTheme_DarkTheme
                        setTheme(currentTheme)
                        recreate() // Reinicie a atividade para aplicar o novo tema
                    }
                }
                myDialog.dismiss()
            }

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()
        }

        val menu = findViewById<LinearLayout>(R.id.menu_horizontal)
        val btnConfig = menu.findViewById<Button>(R.id.btnConfig)
        val btnHome   = menu.findViewById<Button>(R.id.btnHome)
        val btnPerfil = menu.findViewById<Button>(R.id.btnPerfil)

        btnConfig.setOnClickListener{
            val intent = Intent(this, Config::class.java)
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
    }
}
