package com.example.sabersenior.JogoVelha;

import androidx.fragment.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Random;


public class JogoVelha extends Fragment {
    private FragmentJogoBiding binding;
    private Button[] botoes;
    private String[][] tabuleiro;
    private String simbJog1, simbJog2, simbolo, nameJog1, nameJog2;
    private Random random;
    private int numJogadas = 0, numVelhas = 0;
    private int placarJog1 = 0, placarJog2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // habilitar o menu
        setHasOptionsMenu(true);

        // instanciando o binding
        binding = FragmentJogoBinding.inflate(inflater, container, false);

        // instanciar o vetor
        botoes = new Button[9];

        // instanciar o tabuleiro
        tabuleiro = new String[3][3];

        // preenche matriz com string vazia


        for (String[] vetor : tabuleiro) {
            Arrays.fill(vetor, "");
        }

        // define o simbolos dos jogadores 1 e 2
        simbJog1 = PrefsUtil.getSimboloJog1(getContext());
        simbJog2 = PrefsUtil.getSimboloJog2(getContext());

        nameJog1 = PrefNameUtil.getName1(getContext());
        nameJog2 = PrefNameUtil.getName2(getContext());

        binding.text1.setText(getResources().getString(R.string.jogador_1, nameJog1, simbJog1));
        binding.text2.setText(getResources().getString(R.string.jogador_2, nameJog2, simbJog2));

        // instanciar o random
        random = new Random();

        // sorteara quem começa o jogo
        sorteia();

        // atualiza a vez
        atualizaVez();

        // associar o vetor aos botões

        botoes[0] = binding.bt00;
        botoes[1] = binding.bt01;
        botoes[2] = binding.bt02;
        botoes[3] = binding.bt10;
        botoes[4] = binding.bt11;
        botoes[5] = binding.bt12;
        botoes[6] = binding.bt20;
        botoes[7] = binding.bt21;
        botoes[8] = binding.bt22;

        // associa o listener aos botões
        for (Button bt : botoes) {
            bt.setOnClickListener(listenerBotoes);
        }

        // retorna root do binding
        return binding.getRoot();
    }
}
