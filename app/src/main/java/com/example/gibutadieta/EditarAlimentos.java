package com.example.gibutadieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditarAlimentos extends AppCompatActivity {

    private Spinner spinnerEdAlimentos;
    private EditText DescEdAlim;
    private EditText editorEdTextoAli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alimentos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DescEdAlim = (EditText) findViewById(R.id.DescEdAlim);
        editorEdTextoAli = (EditText) findViewById(R.id.editorEdTextoAli);
        spinnerEdAlimentos = (Spinner) findViewById(R.id.spinnerEdAlimentos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Alimetos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdAlimentos.setAdapter(adapter);
    }


    public void CancelarEdAli(View view) {
        finish();
    }

    public void GuardarEdAli(View view) {

        String DescricaoEdAlimentos = DescEdAlim.getText().toString();


        if (DescricaoEdAlimentos.trim().length() == 0){
            DescEdAlim.setError("Campo Obrigatório");
            DescEdAlim.requestFocus();
            return;
        }

        String AlimentosEd = editorEdTextoAli.getText().toString();



        if (AlimentosEd.trim().length() == 0){
            editorEdTextoAli.setError("Campo Obrigatório");
            editorEdTextoAli.requestFocus();
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(editorEdTextoAli.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            editorEdTextoAli.setError("Valor inválido, adicione valor maior que Zero");
            editorEdTextoAli.requestFocus();
            return;
        }

        Toast.makeText(this, "Editado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
