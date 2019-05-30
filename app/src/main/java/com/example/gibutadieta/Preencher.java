package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Preencher extends AppCompatActivity {

    private Spinner spinnerAlimentos;
    private  TiposAlimentos tiposAlimentos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preencher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerAlimentos = (Spinner) findViewById(R.id.spinnerAlimentos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void Cancelar(View view) { // Botão Cancelar
        finish();                     // função Cancelar
    }

    public void Guardar(View view) {

        EditText editorTexto = (EditText) findViewById(R.id.editorTexto);
        String mensagem = editorTexto.getText().toString();
        tiposAlimentos.setId_Alimentos((int) spinnerAlimentos.getSelectedItemId());


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

        Intent intent = new Intent(this, Dados.class);
        intent.putExtra(DefinicaoApp.TEXTOAlimetos, mensagem);
        startActivity(intent);
        finish();

    }






}
