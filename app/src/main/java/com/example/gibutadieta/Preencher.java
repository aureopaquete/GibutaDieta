package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.content.CursorLoader;


public class Preencher extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private Spinner spinnerAlimentos;
    private static final int ID_CURSO_LOADER_ALIMENTOS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preencher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerAlimentos = (Spinner) findViewById(R.id.spinnerAlimentos);

        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_ALIMENTOS, null, this);


    }

    private void mostrarAliemtoSpinner(Cursor cursorAlimentos) {
        SimpleCursorAdapter adaptadorAlimentos = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursorAlimentos,
                new String[]{BdTabelaTiposAlimentos.CAMPO_Alimentos},
                new int[]{android.R.id.text1}
        );
        spinnerAlimentos.setAdapter(adaptadorAlimentos);
    }




    public void Cancelar(View view) { // Botão Cancelar
        finish();                     // função Cancelar
    }

    public void Guardar(View view) {

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

        Intent intent = new Intent(this, Dados.class);
        intent.putExtra(DefinicaoApp.TEXTOAlimetos, mensagem);
        startActivity(intent);
        finish();

    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {

        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_ALIMENTO, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, BdTabelaTiposAlimentos.CAMPO_Alimentos);

        return cursorLoader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mostrarAliemtoSpinner(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mostrarAliemtoSpinner(null);
    }
}
