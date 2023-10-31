package com.example.sabersenior.JogoMemoria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sabersenior.R;

public abstract class JogoMemoria extends Context {
    private Button btn16;
    private Button btn20;
    private Button btn24;

    protected void onCreate(Bundle savedInstanceState) {
        inicializarComponents();
    }

    public void inicializarComponents() {
        btn16 = (Button) btn16.findViewById(R.id.btn16);
        btn20 = (Button) btn20.findViewById(R.id.btn20);
        btn24 = (Button) btn24.findViewById(R.id.btn24);
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
