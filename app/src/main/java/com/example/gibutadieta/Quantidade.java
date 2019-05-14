package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class Quantidade {
    private long id_Quantidade;
    private  String Quantidade;


    //Construtores
    public Quantidade(){
    }

    public Quantidade(int id_Quantidade, String quantidade) {
        this.id_Quantidade = id_Quantidade;
        Quantidade = quantidade;
    }


    //Getter e Setter
    public long getId_Quantidade() {
        return id_Quantidade;
    }

    public void setId_Quantidade(long id_Quantidade) {
        this.id_Quantidade = id_Quantidade;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String quantidade) {
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
        long id_Quantidade = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.ID)
        );

        String Quantidade = cursor.getString(
                cursor.getColumnIndex(BdTabelaQuantidade.CAMPO_QUANTIDADE)
        );

        Quantidade quantidade = new Quantidade();

        quantidade.setId_Quantidade(id_Quantidade);
        quantidade.setQuantidade(Quantidade);

        return quantidade;

    }
}
