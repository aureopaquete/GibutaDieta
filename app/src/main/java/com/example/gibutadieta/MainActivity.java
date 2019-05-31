package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoaderManager.LoaderCallbacks<Cursor>  {

    private AdaptadorGibutaDieta adaptadorGibutaDieta;

    private static final int ID_CURSO_LOADER_GibutaDieta = 0;
    private RecyclerView recyclerViewListarDados;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_GibutaDieta, null, this);

        recyclerViewListarDados = (RecyclerView) findViewById(R.id.recyclerViewListarDados);
        adaptadorGibutaDieta = new AdaptadorGibutaDieta(this);
        recyclerViewListarDados.setAdapter(adaptadorGibutaDieta);
        recyclerViewListarDados.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        // todo: guardar o estado do aplicativo no momento da inversão
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegacao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sobre) {
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Definicoes.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Sobre) {
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);

        } else if (id == R.id.nav_Eliminacao) {
            Intent intent = new Intent(this, Eliminar.class);
            startActivity(intent);

        } else if (id == R.id.nav_Editacao) {
            Intent intent = new Intent(this, Editar.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_closed) {
           finish();
        }else if (id == R.id.nav_Listadados) {
            Intent intent = new Intent(this, Dados.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void Bebidas(View view) {
        Intent intent = new Intent(this, ConsumoLiquido.class);
        startActivity(intent);
    }

    public void Alimentos(View view) {
        Intent intent = new Intent(this, Preencher.class);
        startActivity(intent);
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
