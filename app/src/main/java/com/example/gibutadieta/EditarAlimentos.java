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

public class EditarAlimentos extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_CURSO_LOADER_Alimento = 0;
    private Spinner spinnerEdAlimentos;
    private EditText DescEdAlim;
    private EditText editorEdTextoAli;
    private Uri enderecoAlimentoEditar;
    private TiposAlimentos alimentos = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alimentos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DescEdAlim = (EditText) findViewById(R.id.DescEdAlim);
        editorEdTextoAli = (EditText) findViewById(R.id.editorTexto);
        spinnerEdAlimentos = (Spinner) findViewById(R.id.spinnerAlimentos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Alimetos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdAlimentos.setAdapter(adapter);


        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_Alimento, null, this);


        Intent intent = getIntent();

        long idAlimento = intent.getLongExtra(ListaAlimentos.ID_ALIMENTO, -1);

        if (idAlimento == -1) {
            Toast.makeText(this, "Erro: não foi possível ler", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        enderecoAlimentoEditar = Uri.withAppendedPath(GibutaDietaContentProvider.ENDERECO_ALIMENTO, String.valueOf(idAlimento));

        Cursor cursor = getContentResolver().query(enderecoAlimentoEditar, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, null);

        if (!cursor.moveToNext()) {
            Toast.makeText(this, "Erro: não foi possível ler Dados", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        alimentos = alimentos.fromCursor(cursor);

        DescEdAlim.setText(alimentos.getDescricaoAlimentos());
        editorEdTextoAli.setText(String.valueOf(alimentos.getAlimentos()));


    }

    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_Alimento, null, this);

        super.onResume();
    }


    public void CancelarEdAli(View view) {
        finish();
    }

    public void GuardarEdAli(View view) {


        String DescricaoAlimentos = DescEdAlim.getText().toString();


        if (DescricaoAlimentos.trim().length() == 0){
            DescEdAlim.setError("Campo Obrigatório");
            DescEdAlim.requestFocus();
            return;
        }

        String Alimentos = editorEdTextoAli.getText().toString();



        if (Alimentos.trim().length() == 0){
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




        long id = spinnerEdAlimentos.getSelectedItemId();

        // guardar os dados

        TiposAlimentos alimentos = new TiposAlimentos();

        alimentos.setId(id);
        alimentos.setDescricaoAlimentos(DescricaoAlimentos);
        alimentos.setAlimentos(Alimentos);


        try {
            getContentResolver().insert(GibutaDietaContentProvider.ENDERECO_ALIMENTO, alimentos.getContentValues());
            Toast.makeText(this, getString(R.string.Guardado_com_Sucesso), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ListaAlimentos.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Snackbar.make(
                    editorEdTextoAli,
                    getString(R.string.Erros_ao_Guardar),
                    Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
        }

    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(this, GibutaDietaContentProvider.ENDERECO_ALIMENTO, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, BdTabelaTiposAlimentos.CAMPO_Alimentos);

        return cursorLoader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
