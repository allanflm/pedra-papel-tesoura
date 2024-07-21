package com.allanfelipe.pedra_papel_tesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        //System.out.println("Item clicado: " + escolhaUsuario);

    }


}