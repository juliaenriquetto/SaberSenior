package com.example.sabersenior.PalavraCruzada;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sabersenior.MainActivity;
import com.example.sabersenior.R;

public class Tela_Menu extends AppCompatActivity {

    TextView edtLogin;
    Button Level1, Level2 ,Level3, Level4, Level5, Level6;
    Button Level7, Level8, Level9, Level10, Level11, Level12;
    private String Login;
    private ListView lv;
    private Intent it;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_palavra_cruzada__menu);

        edtLogin = findViewById(R.id.edtLogin);
        Level1 = findViewById(R.id.Level1);
        Level2 = findViewById(R.id.Level2);
        Level3 = findViewById(R.id.Level3);
        Level4 = findViewById(R.id.Level4);
        Level5 = findViewById(R.id.Level5);
        Level6 = findViewById(R.id.Level6);
        Level7 = findViewById(R.id.Level7);
        Level8 = findViewById(R.id.Level8);
        Level9 = findViewById(R.id.Level9);
        Level10 = findViewById(R.id.Level10);
        Level11 = findViewById(R.id.Level11);
        Level12 = findViewById(R.id.Level12);

        lv = findViewById(R.id.LIST);

        Intent itRecebedora = getIntent();
        Bundle bundle = itRecebedora.getExtras();
        Login = bundle.getString("Login");

        edtLogin.setText("Seja bem vindo "+ Login +".");

        it = new Intent(Tela_Menu.this, Tela_Jogo.class);
        it.putExtra("Login", Login);

        Level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",1);
                startActivity(it);
            }
        });

        Level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",2);
                startActivity(it);
            }
        });

        Level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",3);
                startActivity(it);
            }
        });

        Level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",4);
                startActivity(it);
            }
        });

        Level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",5);
                startActivity(it);
            }
        });

        Level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",6);
                startActivity(it);
            }
        });

        Level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",7);
                startActivity(it);
            }
        });

        Level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",8);
                startActivity(it);
            }
        });

        Level9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",9);
                startActivity(it);
            }
        });

        Level10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",10);
                startActivity(it);
            }
        });

        Level11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",11);
                startActivity(it);
            }
        });

        Level12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",12);
                startActivity(it);
            }
        });


    }
}
