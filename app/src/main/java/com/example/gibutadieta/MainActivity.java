package com.example.gibutadieta;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AdaptadorAlimentos adaptadorAlimentos;
    private BdGibutaDietaOpenHelper BdGibutaDietaOpenHelper;
    private SQLiteDatabase conexao;
    private ConstraintLayout layoutPrincipal;

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


        layoutPrincipal = (ConstraintLayout) findViewById(R.id.layoutPrincipal);

        //criarconexao ();
    }

    //metodo pra criar conexao com base de dados
    //Testado dentro de ym bloco try catch

    /*private void criarconexao () {

        try {
            BdGibutaDietaOpenHelper = new BdGibutaDietaOpenHelper(this);
            conexao = BdGibutaDietaOpenHelper.getWritableDatabase();
            Snackbar.make(layoutPrincipal, R.string.conexao_bd,
                    Snackbar.LENGTH_LONG)
                    .setAction("ok",null)
                    .show();
        } catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok",null);
            dlg.show();
        }
    }*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    protected void onResume() {
        super.onResume();
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
            Intent intent = new Intent(this, EliminarBebidas.class);
            startActivity(intent);

        } else if (id == R.id.nav_EditacaoAlimentos) {
            Intent intent = new Intent(this, EditarAlimentos.class);
            startActivity(intent);
        }
        else if (id == R.id.EditorBebidas) {
            Intent intent = new Intent(this, EditarBebidas.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_closed) {
           finish();
        }else if (id == R.id.nav_Listadados) {
            Intent intent = new Intent(this, ListaAlimentos.class);
            startActivity(intent);
        }else if (id == R.id.nav_Bebidas) {
            Intent intent = new Intent(this, ListaBebidas.class);
            startActivity(intent);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void Bebidas(View view) {
        Intent intent = new Intent(this, InserirBebidas.class);
        startActivity(intent);
    }

    public void Alimentos(View view) {
        Intent intent = new Intent(this, InserirAlimentos.class);
        startActivity(intent);
    }


}
