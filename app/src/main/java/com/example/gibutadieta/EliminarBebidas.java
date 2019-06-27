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

public class EliminarBebidas extends AppCompatActivity {

    private Uri ApagarDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_bebidas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TextView textViewOConsumo = (TextView) findViewById(R.id.textViewOConsumo);
        TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        TextView textViewValorCosumo = (TextView) findViewById(R.id.textViewValorCosumo);


        Intent intent = getIntent();
        long idBebida = intent.getLongExtra(ListaBebidas.ID_BEBIDA, -1);
        if (idBebida == -1) {
            Toast.makeText(this, "Erro: não foi possível apagar o item", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        ApagarDados = Uri.withAppendedPath(GibutaDietaContentProvider.ENDERECO_BEBIDA, String.valueOf(idBebida));

        Cursor cursor = getContentResolver().query(ApagarDados, BdTabelaTiposBebidas.TODAS_COLUNAS, null, null, null);

        if (!cursor.moveToNext()) {
            Toast.makeText(this, "Erro: não foi possível apagar o item", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        TiposBebidas bebidas = TiposBebidas.fromCursor(cursor);

        //textViewOConsumo.setText(bebidas.getBebidas());
        textViewDescricao.setText(bebidas.getDescricaoBebidas());
        textViewValorCosumo.setText(String.valueOf(bebidas.getBebidas()+"cl"));

    }




    public void Cancelar3(View view) {
        finish();
    }


    public void Apagar(View view) {
       getContentResolver().delete(ApagarDados, null, null);
        Intent intent = new Intent(this, ListaBebidas.class);
        startActivity(intent);
        finish();
    }
}
