package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class InserirBebidas extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {

    //private static final int ID_CURSO_LOADER_Bebidas = 0;

    private Spinner spinnerBebidas;
    private  EditText DescBebidas;
    private EditText editorTexto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_bebidas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportLoaderManager().initLoader(ID_CURSO_LOADER_Bebidas, null, this);


        DescBebidas = (EditText) findViewById(R.id.DescBebidasEditBe);
        editorTexto2 = (EditText) findViewById(R.id.editorTextoEdBe);
        spinnerBebidas = (Spinner) findViewById(R.id.spinnerEdBebidas);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Bebidas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBebidas.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        //getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_Bebidas, null, this);
        super.onResume();
    }


    private void mostrarBebidaSpinner(Cursor cursorBebidas) {
        SimpleCursorAdapter adaptadorBebidas = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursorBebidas,
                new String[]{BdTabelaTiposBebidas.CAMPO_Bebidas},
                new int[]{android.R.id.text1}
        );
        spinnerBebidas.setAdapter(adaptadorBebidas);
    }

    public void GuardarBebidas(View view) {

        String DescricaoBebidas = DescBebidas.getText().toString();


        if (DescricaoBebidas.trim().length() == 0){
            DescBebidas.setError("Campo Obrigatório");
            DescBebidas.requestFocus();
            return;
        }

        String Bebidas = editorTexto2.getText().toString();


        if (Bebidas.trim().length() == 0){
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


        long id = spinnerBebidas.getSelectedItemId();

        // guardar os dados

        TiposBebidas bebidas = new TiposBebidas();

        bebidas.setId(id);
        bebidas.setBebidas(Bebidas);
        bebidas.setDescricaoBebidas(DescricaoBebidas);


        try {
            getContentResolver().insert(GibutaDietaContentProvider.ENDERECO_ALIMENTO, bebidas.getContentValues());

            Toast.makeText(this, getString(R.string.Guardado_com_Sucesso), Toast.LENGTH_LONG).show();
            finish();
        } catch (Exception e) {
            Snackbar.make(
                    editorTexto2,
                    getString(R.string.Erros_ao_Guardar),
                    Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
        }

        Intent intent = new Intent(this, ListaBebidas.class);
        //intent.putExtra(DefinicaoApp.TEXTOBebidas, mensagem);
        startActivity(intent);
        finish();

    }

    public void CancelarBebidas(View view) {
        finish();
    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_BEBIDA, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, BdTabelaTiposBebidas.CAMPO_Bebidas);

        return cursorLoader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mostrarBebidaSpinner(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mostrarBebidaSpinner(null);
    }
}
