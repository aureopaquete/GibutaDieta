package com.example.gibutadieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
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

        TextView textViewOConsumo = (TextView) findViewById(R.id.textViewOConsumo);
        //TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        //TextView textViewValorCosumo = (TextView) findViewById(R.id.textViewValorCosumo);


        String mensagem = textViewOConsumo.getText().toString();




        if (mensagem.trim().length() == 0) {
            textViewOConsumo.setError("Campo Obrigatório");
            textViewOConsumo.requestFocus();
            return;
        }
        int valor = 0;

        try {
            valor = Integer.parseInt(textViewOConsumo.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            textViewOConsumo.setError("Valor inválido, apague valor mairo que Zero");
            textViewOConsumo.requestFocus();
            return;
        }

        Toast.makeText(this, "Apagado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
