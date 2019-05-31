package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Dados extends AppCompatActivity {

    private AdaptadorGibutaDieta adaptadorGibutaDieta;
    private RecyclerView recyclerViewListarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        adaptadorGibutaDieta = new AdaptadorGibutaDieta(this);
        recyclerViewListarDados.setAdapter(adaptadorGibutaDieta);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));


        mostrarTextoAlimento();
        mostrarTextoBebida();


    }

    private void mostrarTextoAlimento() {

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTOAlimetos);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText(mensagem + " "+"g");

    }

    private void mostrarTextoBebida() {

        Intent intent = getIntent();
        String mensagem  = intent.getStringExtra(DefinicaoApp.TEXTOBebidas);
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setText(mensagem + " "+"ml");

    }

}




