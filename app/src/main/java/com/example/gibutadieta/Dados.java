package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class Dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mostrarTexto();
    }

    private void mostrarTexto() {

        Intent intent = getIntent();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTO);
        RecyclerView recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        recyclerViewListarDados.setItemAnimator(new DefaultItemAnimator());
        recyclerViewListarDados.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

}
