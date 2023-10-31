package com.example.sabersenior.JogoMemoria;

import android.app.ActionBar;
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

public class Activity_24  {
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
    private ImageButton btn16;
    private ImageButton btn17;
    private ImageButton btn18;
    private ImageButton btn19;
    private ImageButton btn20;
    private ImageButton btn21;
    private ImageButton btn22;
    private ImageButton btn23;
    private TextView txtPontos;

    private int batman = R.drawable.abacaxi;
    private int huck = R.drawable.banana;
    private int rangerAzul = R.drawable.beterraba;
    private int goku = R.drawable.caqui;
    private int incrivel =  R.drawable.cereja;
    private int sonic =  R.drawable.framboesa;
    private int mario =  R.drawable.kiwi;
    private int volverine =  R.drawable.laranja;
    private int mulhergata = R.drawable.limao;
    private int aranha = R.drawable.maca;
    private int freeza = R.drawable.melancia;
    private int luigi = R.drawable.uva;

    private  ImageButton botoes[];
    private int imagens[];

    protected void onCreate() {
        inicializarComponents();
        inicializarArrays();
        mostrarCartas();
        esconderTodos();

    }

    public void inicializarComponents(){
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
        btn16 = (ImageButton) btn16.findViewById(R.id.btn16);
        btn17 = (ImageButton) btn17.findViewById(R.id.btn17);
        btn18 = (ImageButton) btn18.findViewById(R.id.btn18);
        btn19 = (ImageButton) btn19.findViewById(R.id.btn19);
        btn20 = (ImageButton) btn20.findViewById(R.id.btn20);
        btn21 = (ImageButton) btn21.findViewById(R.id.btn21);
        btn22 = (ImageButton) btn22.findViewById(R.id.btn22);
        btn23 = (ImageButton) btn23.findViewById(R.id.btn23);
        txtPontos = (TextView) txtPontos.findViewById(R.id.txtPontos);
    }

    public  void  inicializarArrays() {
        botoes = new ImageButton[] {
                btn0, btn1,  btn2,  btn3, btn4, btn5,  btn6,  btn7,
                btn8, btn9,  btn10,  btn11, btn12, btn13,  btn14,  btn15,
                btn16, btn17,  btn18,  btn19, btn20, btn21,  btn22, btn23
        };

        imagens = new int[]{
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
                mulhergata, aranha, freeza, luigi, mulhergata, aranha, freeza, luigi
        };
    }


    //EMBARALHA O ARRAY DE BUTTONS E DE IMAGENS, EM SEGUIDA, ATRIBUI CADA IMAGEM COMO
    //BACKGROUND PARA O RESPECTIVO BUTTON
    public void mostrarCartas() {
        Collections.shuffle(Arrays.asList(imagens));
        Collections.shuffle(Arrays.asList(botoes));

        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setBackgroundResource(imagens[i]);
    }

    //ATRIBUI UMA IMAGEM SUPERIOR AO BACKGROUND USANDO A IMAGEM 'capa.png'
    public void esconderTodos() {
        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setImageResource(R.drawable.esconde);
    }

    public void onClick( View v) {
        ImageButton cartaTocada = (ImageButton) v;

        if(cartasViradas == 0) {   //SE NÃO HOUVER NENHUMA CARTA VIRADA NA MESA, VIRA, E ATUALIZA PARA UMA CARTA VIRADA
            primeiraCartaVirada = cartaTocada;
            viraCarta(cartaTocada);
            cartasViradas = 1;
            primeiraCartaVirada.setClickable(false);

        }else { //SE JÁ HOUVER UMA CARTA VIRADA, EXECUTA A COMPARAÇÃO ENTRE AS DUAS, VERIFICA SE SÃO IGUAIS E ATUALIZA PARA NENHUMA CARTA VIRADA
            segundaCartaVirada = cartaTocada;
            cartasViradas = 0;
            viraCarta(segundaCartaVirada);
            segundaCartaVirada.setClickable(false);

            if(verificaCartas(primeiraCartaVirada, segundaCartaVirada)) {
                pontos++;
                verificarPlacar();
            }
            else {

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
    private void viraCarta(ImageButton cartaTocada)    {
        cartaTocada.setImageResource(0);
    }

    public void  verificarPlacar()
    {
        if(pontos > 0)
            txtPontos.setTextColor(Color.rgb(0, 14, 0)); //Não está funcionando, mas era para ficar verde aqui '-'
        else if(pontos == 0)
            txtPontos.setTextColor(Color.rgb(14,14,14));//Aqui preto
        else
            txtPontos.setTextColor(Color.rgb(14,0,0));// E aqui vermelho '-'

        txtPontos.setText("Pontos: " + pontos);
    }



    //VERIFICA SE AS IMAGENS DAS CARTAS SÃO IGUAIS
    private boolean verificaCartas(ImageButton carta1, ImageButton carta2) {
        if(carta1.getBackground().getConstantState().equals(carta2.getBackground().getConstantState()))
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
