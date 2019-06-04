package com.example.gibutadieta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarBebidas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_bebidas);
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
