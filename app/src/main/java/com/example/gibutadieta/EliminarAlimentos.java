package com.example.gibutadieta;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EliminarAlimentos extends AppCompatActivity {

    private Uri ApagarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_alimentos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewOConsumo = (TextView) findViewById(R.id.textViewOConsumo);
        TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        TextView textViewValorCosumo = (TextView) findViewById(R.id.textViewValorCosumo);


        Intent intent = getIntent();
        long idAlimento = intent.getLongExtra(ListaAlimentos.ID_ALIMENTO, -1);
        if (idAlimento == -1) {
            Toast.makeText(this, "Erro: não foi possível apagar o item", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        ApagarDados = Uri.withAppendedPath(GibutaDietaContentProvider.ENDERECO_ALIMENTO, String.valueOf(idAlimento));

        Cursor cursor = getContentResolver().query(ApagarDados, BdTabelaTiposAlimentos.TODAS_COLUNAS, null, null, null);

        if (!cursor.moveToNext()) {
            Toast.makeText(this, "Erro: não foi possível apagar o item", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        TiposAlimentos alimentos = TiposAlimentos.fromCursor(cursor);

        textViewOConsumo.setText(alimentos.getAlimentos());
        textViewDescricao.setText(alimentos.getDescricaoAlimentos());
        textViewValorCosumo.setText(String.valueOf(alimentos.getAlimentos()));


    }

    public void CancelarAlime(View view) {
        finish();
    }

    public void ApagarAliem(View view) {
        getContentResolver().delete(ApagarDados, null, null);
        Intent intent = new Intent(this, ListaAlimentos.class);
        startActivity(intent);
        finish();
    }
}
