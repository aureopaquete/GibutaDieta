package com.example.gibutadieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditarBebidas extends AppCompatActivity {

    private Spinner spinnerEdBebidas;
    private  EditText DescBebidasEditBe;
    private EditText editorTextoEdBe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_bebidas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DescBebidasEditBe = (EditText) findViewById(R.id.DescBebidasEditBe);
        editorTextoEdBe = (EditText) findViewById(R.id.editorTextoEdBe);
        spinnerEdBebidas = (Spinner) findViewById(R.id.spinnerEdBebidas);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Bebidas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdBebidas.setAdapter(adapter);


    }

    public void CancelarEdBebidas(View view) {
        finish();
    }

    public void GuardarEdBebidas(View view) {


        String DescricaoEdBebidas = DescBebidasEditBe.getText().toString();


        if (DescricaoEdBebidas.trim().length() == 0){
            DescBebidasEditBe.setError("Campo Obrigatório");
            DescBebidasEditBe.requestFocus();
            return;
        }

        String BebidasEd = editorTextoEdBe.getText().toString();


        if (BebidasEd.trim().length() == 0){
            editorTextoEdBe.setError("Campo Obrigatório");
            editorTextoEdBe.requestFocus();
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(editorTextoEdBe.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }

        if (valor == 0) {
            editorTextoEdBe.setError("Valor inválido, adicione valor maior que Zero");
            editorTextoEdBe.requestFocus();
            return;
        }


        Toast.makeText(this, "Editado com Sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
