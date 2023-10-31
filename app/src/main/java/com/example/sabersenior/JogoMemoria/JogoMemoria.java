package com.example.sabersenior.JogoMemoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class JogoMemoria extends ActionBarActivy implements View.OnClickListener {
    private Button btn16;
    private Button btn20;
    private Button btn24;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        inicializarComponents();
        adicionarOuvintes();

    }

    public void inicializarComponents() {
        btn16 = (Button) findViewById(R.id.btn16);
        btn20 = (Button) findViewById(R.id.btn20);
        btn24 = (Button) findViewById(R.id.btn24);
    }

    public void adicionarOuvintes() {
        btn16.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn24.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn16:
                intent.setClass(this, Activity_16.class);
                startActivity(intent);
                break;
            case R.id.btn20:
                intent.setClass(this, Activity_20.class);
                startActivity(intent);
                break;
            case R.id.btn24:
                intent.setClass(this, Activity_24.class);
                startActivity(intent);
                break;
        }
    }
}
