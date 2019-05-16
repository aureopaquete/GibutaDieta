package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class ConsumoLiquido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_liquido);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void GuardarBebidas(View view) {
        EditText editorTexto = (EditText) findViewById(R.id.editorTexto);
        String mensagem = editorTexto.getText().toString();


        if (mensagem.trim().length() == 0){
            editorTexto.setError("Campo Obrigatório");
            editorTexto.requestFocus();
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(editorTexto.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            editorTexto.setError("Valor inválido, adicione valor maior que Zero");
            editorTexto.requestFocus();
            return;
        }

        Toast.makeText(this, "Guardado com sucesso", Toast.LENGTH_SHORT).show();

        Date data = new Date();
        Intent intent = new Intent(this, ConsumoLiquido.class);
        intent.putExtra(DefinicaoApp.TEXTO, mensagem);
        intent.putExtra(DefinicaoApp.DATA, data);
        startActivity(intent);
        finish();

    }

    public void CancelarBebidas(View view) {
        finish();
    }
}
