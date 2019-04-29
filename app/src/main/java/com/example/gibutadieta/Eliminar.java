package com.example.gibutadieta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void Cancelar3(View view) {
        finish();
    }

    public void Apagar(View view) {

        EditText TextApagar = (EditText) findViewById(R.id.TextoApagar);
        String mensagem = TextApagar.getText().toString();


        if (mensagem.trim().length() == 0) {
            TextApagar.setError("Campo Obrigatório");
            TextApagar.requestFocus();
            return;
        }
        int valor = 0;

        try {
            valor = Integer.parseInt(TextApagar.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            TextApagar.setError("Apagar valor maior que 0");
            TextApagar.requestFocus();
            return;
        }
        Toast.makeText(this, "Apagado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
