package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class VerDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_dados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mostrarTextoAgua();
        mostrarTextoProte();
        mostrarTextoLegu();
        mostrarTextoCarbo();

    }

    public void conluido(View view) {
        finish();
    }

    private void mostrarTextoAgua() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTO);
        TextView textViewAguaGeral = (TextView) findViewById(R.id.textViewAguaGeral);
        textViewAguaGeral.setText(mensagem);
    }

    private void mostrarTextoProte() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTOPROTE);
        TextView textViewProteGeral = (TextView) findViewById(R.id.textViewProteGeral);
        textViewProteGeral.setText(mensagem);
    }

    private void mostrarTextoLegu() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTOLEGU);
        TextView textViewLeguGeral = (TextView) findViewById(R.id.textViewLeguGeral);
        textViewLeguGeral.setText(mensagem);
    }

    private void mostrarTextoCarbo() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTOCARBO);
        TextView textViewCarboGeral = (TextView) findViewById(R.id.textViewCarboGeral);
        textViewCarboGeral.setText(mensagem);
    }
}

