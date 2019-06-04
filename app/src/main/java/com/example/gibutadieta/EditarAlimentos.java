package com.example.gibutadieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarAlimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alimentos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void Cancelar(View view) {
        finish();
    }

    public void Guardar(View view) {

        EditText TextEditor = (EditText) findViewById(R.id.editorTexto);
        String mensagem = TextEditor.getText().toString();


        if (mensagem.trim().length() == 0) {
            TextEditor.setError("Campo Obrigatório");
            TextEditor.requestFocus();
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(TextEditor.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            TextEditor.setError("Valor inválido, edite valor maior que Zero");
            TextEditor.requestFocus();
            return;
        }

        Toast.makeText(this, "Editado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
