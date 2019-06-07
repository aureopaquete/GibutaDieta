package com.example.gibutadieta;

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


public class ListaGeral extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    private static final int ID_CURSO_LOADER_GibutaDieta = 0;

    private AdaptadorGibutaDieta adaptadorGibutaDieta;
    private RecyclerView recyclerViewListarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_geral);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getSupportLoaderManager().initLoader(ID_CURSO_LOADER_GibutaDieta, null, this);


        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        adaptadorGibutaDieta = new AdaptadorGibutaDieta(this);
        recyclerViewListarDados.setHasFixedSize(true);
        recyclerViewListarDados.setAdapter(adaptadorGibutaDieta);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));

        //mostrarTextoAlimento();
        //mostrarTextoBebida();
    }


    @Override
    protected void onResume() {
        //getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_GibutaDieta, null, this);
        super.onResume();
    }




    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
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

    /*
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
    */
}




