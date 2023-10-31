package com.example.sabersenior.JogoMemoria;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sabersenior.R;

import java.util.Arrays;
import java.util.Collections;


public class Activity_16 {
    private int cartasViradas = 0; //VERIFICA QUANTAS CARTAS ESTÃO VIRADAS AO MESMO TEMPO
    private int pontos = 0;

    private ImageButton primeiraCartaVirada;
    private ImageButton segundaCartaVirada;
    private ImageButton btn0;
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;
    private ImageButton btn8;
    private ImageButton btn9;
    private ImageButton btn10;
    private ImageButton btn11;
    private ImageButton btn12;
    private ImageButton btn13;
    private ImageButton btn14;
    private ImageButton btn15;
    private TextView txtPontos;

    private int batman = R.drawable.caqui;
    private int huck = R.drawable.morango;
    private int rangerAzul = R.drawable.cereja;
    private int goku = R.drawable.framboesa;
    private int incrivel = R.drawable.melao;
    private int sonic = R.drawable.pera;
    private int mario = R.drawable.beterraba;
    private int volverine = R.drawable.mirtilo;

    private ImageButton botoes[];
    private int imagens[];

    protected void onCreate(Bundle savedInstanceState) {
        inicializarComponents();
        inicializarArrays();
        mostrarCartas();
        //ANTES DE ESCONDER, É NECESSARIO DAR UMA PAUSA PARA O USUÁRIO "DECORAR" AS CARTAS :/
        esconderTodos();
    }

    public void inicializarComponents() {
        btn0 =  (ImageButton) btn0.findViewById(R.id.btn0);
        btn1 =  (ImageButton) btn1.findViewById(R.id.btn1);
        btn2 =  (ImageButton) btn2.findViewById(R.id.btn2);
        btn3 =  (ImageButton) btn3.findViewById(R.id.btn3);
        btn4 =  (ImageButton) btn4.findViewById(R.id.btn4);
        btn5 =  (ImageButton) btn5.findViewById(R.id.btn5);
        btn6 =  (ImageButton) btn6.findViewById(R.id.btn6);
        btn7 =  (ImageButton) btn7.findViewById(R.id.btn7);
        btn8 =  (ImageButton) btn8.findViewById(R.id.btn8);
        btn9 =  (ImageButton) btn9.findViewById(R.id.btn9);
        btn10 = (ImageButton) btn10.findViewById(R.id.btn10);
        btn11 = (ImageButton) btn11.findViewById(R.id.btn11);
        btn12 = (ImageButton) btn12.findViewById(R.id.btn12);
        btn13 = (ImageButton) btn13.findViewById(R.id.btn13);
        btn14 = (ImageButton) btn14.findViewById(R.id.btn14);
        btn15 = (ImageButton) btn15.findViewById(R.id.btn15);
        txtPontos = (TextView) txtPontos.findViewById(R.id.txtPontos);
    }

    public void inicializarArrays() {
        botoes = new ImageButton[]{
                btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,
                btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15
        };

        imagens = new int[]{
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine
        };
    }


    //EMBARALHA O ARRAY DE BUTTONS E DE IMAGENS, EM SEGUIDA, ATRIBUI CADA IMAGEM COMO
    //BACKGROUND PARA O RESPECTIVO BUTTON
    public void mostrarCartas() {
        Collections.shuffle(Arrays.asList(imagens));
        Collections.shuffle(Arrays.asList(botoes));

        for (int i = 0; i < botoes.length; i++)
            botoes[i].setBackgroundResource(imagens[i]);
    }


    //ATRIBUI UMA IMAGEM SUPERIOR AO BACKGROUND USANDO A IMAGEM 'capa.png'
    public void esconderTodos() {
        for (int i = 0; i < botoes.length; i++)
            botoes[i].setImageResource(R.drawable.esconde);
    }

    public void onClick(View v) {
        ImageButton cartaTocada = (ImageButton) v;

        if (cartasViradas == 0) {   //SE NÃO HOUVER NENHUMA CARTA VIRADA NA MESA, VIRA, E ATUALIZA PARA UMA CARTA VIRADA
            primeiraCartaVirada = cartaTocada;
            viraCarta(cartaTocada);
            cartasViradas = 1;
            primeiraCartaVirada.setClickable(false);

        } else { //SE JÁ HOUVER UMA CARTA VIRADA, EXECUTA A COMPARAÇÃO ENTRE AS DUAS, VERIFICA SE SÃO IGUAIS E ATUALIZA PARA NENHUMA CARTA VIRADA
            segundaCartaVirada = cartaTocada;
            cartasViradas = 0;
            viraCarta(segundaCartaVirada);
            segundaCartaVirada.setClickable(false);

            if (verificaCartas(primeiraCartaVirada, segundaCartaVirada)) {
                pontos++;
                verificarPlacar();
            } else {

                // ANTES DE VIRAR AS CARTAS ERRADAS NOVAMENTE É PRECISO
                // DAR UM DELAY PARA QUE O USUÁRIO VEJA AS DUAS CARTAS
                // NÃO CORRESPONDENTES...

                pontos--;
                verificarPlacar();
                desvirarCartas(primeiraCartaVirada, segundaCartaVirada);
                primeiraCartaVirada.setClickable(true);
                segundaCartaVirada.setClickable(true);
            }
        }
    }

    //PARA "VIRAR" A CARTA, BASTA ATRIBUIR O VALOR '0' A FUNÇAO  TORNANDO A IMAGEM
    //SUPERIOR TRANSPARENTE FICANDO VISIVEL SOMENTE O BACKGROUND
    private void viraCarta(ImageButton cartaTocada) {
        cartaTocada.setImageResource(0);
    }

    public void verificarPlacar() {
        if (pontos > 0)
            txtPontos.setTextColor(Color.rgb(0, 14, 0)); //Não está funcionando, mas era para ficar verde aqui '-'
        else if (pontos == 0)
            txtPontos.setTextColor(Color.rgb(14, 14, 14));//Aqui preto
        else
            txtPontos.setTextColor(Color.rgb(14, 0, 0));// E aqui vermelho '-'

        txtPontos.setText("Pontos: " + pontos);
    }


    //VERIFICA SE AS IMAGENS DAS CARTAS SÃO IGUAIS
    private boolean verificaCartas(ImageButton carta1, ImageButton carta2) {
        if (carta1.getBackground().getConstantState().equals(carta2.getBackground().getConstantState()))
            return true;
        else
            return false;
    }


    //ATRIBUI A IMAGEM SUPERIOR PARA A IMAGEM DE CAPA NOVAMENTE
    public void desvirarCartas(ImageButton carta1, ImageButton carta2) {
        carta1.setImageResource(R.drawable.esconde);
        carta2.setImageResource(R.drawable.esconde);
    }
}
