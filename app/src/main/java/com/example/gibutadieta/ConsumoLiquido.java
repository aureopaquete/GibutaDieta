package com.example.gibutadieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ConsumoLiquido extends AppCompatActivity {

    private Spinner spinnerBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_liquido);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerBebidas = (Spinner) findViewById(R.id.spinnerBebidas);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Bebidas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBebidas.setAdapter(adapter);


    }

    public void GuardarBebidas(View view) {
        EditText editorTexto2 = (EditText) findViewById(R.id.editorTexto2);
        String mensagem = editorTexto2.getText().toString();


        if (mensagem.trim().length() == 0){
            editorTexto2.setError("Campo Obrigatório");
            editorTexto2.requestFocus();
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(editorTexto2.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            editorTexto2.setError("Valor inválido, adicione valor maior que Zero");
            editorTexto2.requestFocus();
            return;
        }

        Toast.makeText(this, "Guardado com sucesso", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Dados.class);
        intent.putExtra(DefinicaoApp.TEXTOBebidas, mensagem);
        startActivity(intent);
        finish();

    }

    public void CancelarBebidas(View view) {
        finish();
    }
}
