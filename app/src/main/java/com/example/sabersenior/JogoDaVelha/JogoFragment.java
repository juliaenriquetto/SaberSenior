package com.example.sabersenior.JogoDaVelha;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sabersenior.R;

import java.util.Arrays;
import java.util.Random;
import java.util.zip.Inflater;

public class JogoFragment extends Fragment {
    private Fragment binding;
    private Button[] botoes;
    private String[][] tabuleiro;
    private String simbJog1, simbJog2, simbolo, nameJog1, nameJog2;private Random random;private int numJogadas = 0, numVelhas = 0;
    // variaveis para o placar
    private int placarJog1 = 0, placarJog2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // habilitar o menu
        setHasOptionsMenu(true);

        // instanciando o binding
        Inflater FragmentJogoBinding;
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


        // instanciar o random
        random = new Random();

        // sorteara quem começa o jogo
        sorteia();


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

    private void sorteia() {
        // se gerar um valor verdadeiro jogador 1 começa
        // caso contrario jogador 2 começa
        if (random.nextBoolean()) {
            simbolo = simbJog1;
        } else {
            simbolo = simbJog2;
        }
    }

    private void reseta() {

        for (String[] vetor : tabuleiro) {
            Arrays.fill(vetor, "");
        }

        numJogadas = 0;

        sorteia();
    }


    private boolean venceu() {
        // verifica se venceu nas linhas
        for (int li = 0; li < 3; li++) {
            if (tabuleiro[li][0].equals(simbolo) && tabuleiro[li][1].equals(simbolo) && tabuleiro[li][2].equals(simbolo)) {
                return true;
            }
        }
        // verifica se venceu nas colunas
        for (int col = 0; col < 3; col++) {
            if (tabuleiro[0][col].equals(simbolo) && tabuleiro[1][col].equals(simbolo) && tabuleiro[2][col].equals(simbolo)) {
                return true;
            }
        }

        // verifica nas diagonais
        if (tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) {
            return true;
        }
        if (tabuleiro[0][2].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) {
            return true;
        }
        return false;
    }

    private View.OnClickListener listenerBotoes = btPress -> {
        // incrementa numero de jogadas
        numJogadas++;

        // obtem o nome do botao
        String nomeBotao = getContext().getResources().getResourceName(btPress.getId());
        // extrai a posição
        String posicao = nomeBotao.substring(nomeBotao.length() - 2);
        // extrai linha e coluna da String posição
        int linha = Character.getNumericValue(posicao.charAt(0));
        int coluna = Character.getNumericValue(posicao.charAt(1));
        // preencher a posição da matriz com o simbolo da vez
        tabuleiro[linha][coluna] = simbolo;
        // faz um casting de view para button
        Button botao = (Button) btPress;
        // "seta" o simbolo do botao pressionado
        botao.setText(simbolo);
        // troca o background para branco
        // troca cor da letra para preto
        botao.setTextColor(Color.BLACK);
        // desabilita botao que foi jogado
        botao.setClickable(false);

        if (numJogadas >= 0 && venceu()) {

            // informa que houve um vencedor
            Toast.makeText(getContext(), "venceu", Toast.LENGTH_SHORT).show();

            if (simbolo.equals(simbJog1)) {
                placarJog1++;
            } else {
                placarJog2++;
            }
            // reseta
            reseta();
        } else if (numJogadas == 9) {
            numVelhas += 1;
            // informa que deu velha
            Toast.makeText(getContext(), "deu velha", Toast.LENGTH_LONG).show();
            // reseta
            reseta();
        } else {
            simbolo = simbolo.equals(simbJog1) ? simbJog2 : simbJog1;
        }
    };

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        // verificar qual opção foi selecionada
//        switch (item.getItemId()) {
//            // caso seja o opção de resetar
//            case R.id.menu_resetar:
//                placarJog2 = 0;
//                placarJog1 = 0;
//                atualizaPlacar();
//                reseta();
//                break;
//            // caso seja a opção de preferencias
//            case R.id.menu_pref:
//                NavHostFragment.findNavController(JogoFragment.this).navigate(R.id.action_jogoFragment_to_prefFragment);
//                break;
//            case R.id.menu_inicio:
//                NavHostFragment.findNavController(JogoFragment.this).navigate(R.id.action_jogoFragment_to_inicioFragment);
//                break;
//            case R.id.menu_resetar_tudo:
//
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.getContext());
//                alertDialogBuilder.setTitle("ALERTA");
//                alertDialogBuilder.setMessage("Deseja resetar tudo ?");
//                alertDialogBuilder.setCancelable(false);
//
//                alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        nameJog1 = "Jogador 1";
//                        nameJog2 = "Jogador 2";
//                        simbJog1 = "X";
//                        simbJog2 = "O";
//                        placarJog2 = 0;
//                        placarJog1 = 0;
//                        atualizaPlacar();
//                        reseta();
//
//
//                        binding.text1.setText(getResources().getString(R.string.jogador_1, nameJog1, simbJog1));
//                        binding.text2.setText(getResources().getString(R.string.jogador_2, nameJog2, simbJog2));
//
//                        atualizaVez();
//                    }
//                });
//
//                alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // clicou não
//                    }
//                });
//                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // cancelou
//                    }
//                });
//
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();
//                break;
//            case R.id.menu_nomes:
//                NavHostFragment.findNavController(JogoFragment.this).navigate(R.id.action_jogoFragment_to_prefNameFragment);
//                break;
//        }
//        return true;
//    }

    @Override
    public void onStart() {
        super.onStart();

        AppCompatActivity minhaActivity = (AppCompatActivity) getActivity();
        minhaActivity.getSupportActionBar().show();
        minhaActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}
