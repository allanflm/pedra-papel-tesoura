package com.allanfelipe.pedra_papel_tesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TESOURA = "TESOURA";
    private final String PEDRA = "PEDRA";
    private final String PAPEL = "PAPEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador(PEDRA);
    }

    public void selecionarPapel(View view) {
        verificarGanhador(PAPEL);
    }

    public void selecionarTesoura(View view) {
        verificarGanhador(TESOURA);
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {PEDRA, PAPEL, TESOURA};
        int numeroAleatorio = new Random().nextInt(3);
        String escolhaDoApp = opcoes[numeroAleatorio];

        ImageView imagemApp = findViewById(R.id.image_app);

        switch (escolhaDoApp) {
            case PEDRA:
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case PAPEL:
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case TESOURA:
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaDoApp;

    }
    private void verificarGanhador(String escolhaUsuario) {
        String escolhaDoApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if ((escolhaDoApp == PEDRA && escolhaUsuario == TESOURA) ||
                (escolhaDoApp == PAPEL && escolhaUsuario == PEDRA) ||
                (escolhaDoApp == TESOURA && escolhaUsuario == PAPEL)) { // App ganhou!
            textoResultado.setText("Voce perdeu! :(");

        } else if ((escolhaUsuario == PEDRA && escolhaDoApp == TESOURA) ||
                (escolhaUsuario == PAPEL && escolhaDoApp == PEDRA) ||
                (escolhaUsuario == TESOURA && escolhaDoApp == PAPEL)) { // Usuario é o ganhador!
            textoResultado.setText("Você ganhou!!! :)");
        } else { // Empate

            textoResultado.setText("Empatamos");

        }

    }


}