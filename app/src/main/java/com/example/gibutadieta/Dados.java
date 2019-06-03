package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Dados extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private AdaptadorGibutaDieta adaptadorGibutaDieta;
    private RecyclerView recyclerViewListarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        recyclerViewListarDados.setHasFixedSize(true);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));
        adaptadorGibutaDieta = new AdaptadorGibutaDieta(this);
        recyclerViewListarDados.setAdapter(adaptadorGibutaDieta);



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


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_ALIMENTO, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, BdTabelaTiposAlimentos.CAMPO_Alimentos);

        return cursorLoader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorGibutaDieta.setCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adaptadorGibutaDieta.setCursor(null);
    }
}




