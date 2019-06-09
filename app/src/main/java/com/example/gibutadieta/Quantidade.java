package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class Quantidade {
    private long id;
    private  int Quantidade;



    //Getter e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }



    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaQuantidade.CAMPO_QUANTIDADE, Quantidade);
        return valores;
    }


    //função estática que permita obter um objeto a partir de um cursor
    public static Quantidade fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTabelaQuantidade._ID)
        );

        int Quantidade = cursor.getInt(
                cursor.getColumnIndex(BdTabelaQuantidade.CAMPO_QUANTIDADE)
        );

        Quantidade quantidade = new Quantidade();

        quantidade.setId(id);
        quantidade.setQuantidade(Quantidade);

        return quantidade;

    }
}
