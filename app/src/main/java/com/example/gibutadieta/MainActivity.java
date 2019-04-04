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

    public void Agua(View view) {
        Intent intent = new Intent(this, Inclusao.class);
        Toast.makeText(this, "Adicionar Água", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void Proteinas(View view) {
        Intent intent = new Intent(this, Inclusao.class);
        Toast.makeText(this, "Adicionar Proteinas", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void Carbo(View view) {
        Intent intent = new Intent(this, Inclusao.class);
        Toast.makeText(this, "Adicionar Carboidratos", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void Legumes(View view) {
        Intent intent = new Intent(this, Inclusao.class);
        Toast.makeText(this, "Adicionar Legumes", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void Sair(View view) {
        finish();
    }

    public void Dados(View view) {
    }
}
