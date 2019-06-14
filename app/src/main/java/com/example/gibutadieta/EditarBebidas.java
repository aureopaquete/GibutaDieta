package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import android.widget.Spinner;
import android.widget.Toast;

public class EditarBebidas extends AppCompatActivity   implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_CURSO_LOADER_Bebidas = 0;

    private Spinner spinnerEdBebidas;
    private  EditText DescBebidasEditBe;
    private EditText editorTextoEdBe;
    private Uri enderecoBebidaEditar;
    private TiposBebidas bebidas = null;

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


        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_Bebidas, null, this);


        Intent intent = getIntent();

        long idLivro = intent.getLongExtra(ListaBebidas.ID_BEBIDA, -1);

        if (idLivro == -1) {
            Toast.makeText(this, "Erro: não foi possível ler", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        enderecoBebidaEditar = Uri.withAppendedPath(GibutaDietaContentProvider.ENDERECO_BEBIDA, String.valueOf(idLivro));

        Cursor cursor = getContentResolver().query(enderecoBebidaEditar, BdTabelaTiposBebidas.TODAS_COLUNAS, null, null, null);

        if (!cursor.moveToNext()) {
            Toast.makeText(this, "Erro: não foi possível ler Dados", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        bebidas = bebidas.fromCursor(cursor);

        DescBebidasEditBe.setText(bebidas.getDescricaoBebidas());
        editorTextoEdBe.setText(String.valueOf(bebidas.getBebidas()));


    }

    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_Bebidas, null, this);

        super.onResume();
    }


    public void CancelarEdBebidas(View view) {
        finish();
    }

    public void GuardarEdBebidas(View view) {


        String DescricaoBebidas = DescBebidasEditBe.getText().toString();


        if (DescricaoBebidas.trim().length() == 0){
            DescBebidasEditBe.setError("Campo Obrigatório");
            DescBebidasEditBe.requestFocus();
            return;
        }

        String Bebidas = editorTextoEdBe.getText().toString();


        if (Bebidas.trim().length() == 0){
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


        long id = spinnerEdBebidas.getSelectedItemId();

        // guardar os dados

        TiposBebidas bebidas = new TiposBebidas();

        bebidas.setId(id);
        bebidas.setDescricaoBebidas(DescricaoBebidas);
        bebidas.setBebidas(Bebidas);

        try {
            getContentResolver().insert(GibutaDietaContentProvider.ENDERECO_BEBIDA, bebidas.getContentValues());
            Toast.makeText(this, getString(R.string.Guardado_com_Sucesso), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ListaBebidas.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Snackbar.make(
                    editorTextoEdBe,
                    getString(R.string.Erros_ao_Guardar),
                    Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
        }

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_BEBIDA, BdTabelaTiposBebidas.TODAS_COLUNAS, null, null, BdTabelaTiposBebidas.CAMPO_Bebidas);

        return cursorLoader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
