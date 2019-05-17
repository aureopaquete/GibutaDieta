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
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Date;

public class Dados extends AppCompatActivity {

    private ListAdapter adapter;
    private RecyclerView recyclerViewListarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mostrarTexto();
        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));


    }

    private void mostrarTexto() {

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(DefinicaoApp.TEXTO);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText(mensagem + " "+"g");

    }

}




