package com.example.gibutadieta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }



    public void Retroceder(View view) {
        finish();
    }

    public void Salvar(View view) {
        EditText TextEditor = (EditText) findViewById(R.id.TextEditor);
        String mensagem = TextEditor.getText().toString();


        if (mensagem.trim().length() == 0) {
            TextEditor.setError("Campo Obrigatório");
            TextEditor.requestFocus();
            return;
        }

        Toast.makeText(this, "Editado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
