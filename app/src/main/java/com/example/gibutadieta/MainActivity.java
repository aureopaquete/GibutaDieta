package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_menus);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    protected void onSaveInstanceState(Bundle outState) {
        // todo: guardar o estado do aplicativo no momento da inversão
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void Sair(View view) {
        finish();
    }

    public void Adicionar(View view) {
        Intent intent = new Intent(this, Preencher.class);
        startActivity(intent);
    }

    public void Editar(View view) {
        Intent intent = new Intent(this, Editar.class);
        startActivity(intent);
    }

    public void Deletar(View view) {
        Intent intent = new Intent(this, Eliminar.class);
        startActivity(intent);
    }
    public void Dados(View view) {
        Intent intent = new Intent(this, Dados.class);
        startActivity(intent);
    }
}
