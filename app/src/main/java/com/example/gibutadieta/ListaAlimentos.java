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
import android.view.Menu;
import android.view.MenuItem;


public class ListaAlimentos extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    private static final int ID_CURSO_LOADER_GibutaDieta = 0;
    public static final String ID_ALIMENTO ="ID_ALIMENTO";

    private AdaptadorAlimentos adaptadorAlimentos;
    private RecyclerView recyclerViewListarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_geral);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_GibutaDieta, null, this);


        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        adaptadorAlimentos = new AdaptadorAlimentos(this);
        recyclerViewListarDados.setHasFixedSize(true);
        recyclerViewListarDados.setAdapter(adaptadorAlimentos);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_GibutaDieta, null, this);
        super.onResume();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apagador, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_apgador) {
            Intent intent = new Intent(this, EliminarAlimentos.class);
            intent.putExtra(ID_ALIMENTO, adaptadorAlimentos.getAlimentoSelecionado().getId());
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }




    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_ALIMENTO, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, BdTabelaTiposAlimentos.CAMPO_Alimentos);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorAlimentos.setCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adaptadorAlimentos.setCursor(null);
    }

}




