package com.example.sabersenior

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Config : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        //Alert Dialog Btn_SobreNos

        val btnSobreNos = findViewById<Button>(R.id.btnSobre)

        btnSobreNos.setOnClickListener()
        {
            val dilaogBinding = layoutInflater.inflate(R.layout.custom_allert_sobre_nos, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dilaogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val SairSobre = dilaogBinding.findViewById<Button>(R.id.dialog_Sair)

            SairSobre.setOnClickListener()
            {
                myDialog.dismiss()
            }
        }





    }
}