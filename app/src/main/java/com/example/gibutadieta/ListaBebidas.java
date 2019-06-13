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

public class ListaBebidas extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    private static final int ID_CURSO_LOADER_GibutaDieta = 0;

    private AdaptadorBebidas adaptadorBebidas;
    private RecyclerView recyclerViewBebidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bebidas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //getSupportLoaderManager().initLoader(ID_CURSO_LOADER_GibutaDieta, null, this);


        recyclerViewBebidas = (RecyclerView) findViewById(R.id.recyclerViewBebidas);
        adaptadorBebidas = new AdaptadorBebidas(this);
        recyclerViewBebidas.setHasFixedSize(true);
        recyclerViewBebidas.setAdapter(adaptadorBebidas);
        recyclerViewBebidas.setLayoutManager(new LinearLayoutManager(this));

    }

    protected void onResume() {
        //getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_GibutaDieta, null, this);
        super.onResume();
    }



    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_BEBIDA, BdTabelaTiposBebidas.TODAS_COLUNAS, null, null, BdTabelaTiposBebidas.CAMPO_Bebidas);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorBebidas.setCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adaptadorBebidas.setCursor(null);
    }
}
