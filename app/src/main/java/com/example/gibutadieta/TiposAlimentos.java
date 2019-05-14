package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposAlimentos {
    long id_Alimentos;
    private String Alimentos;

    //Construtores
    public TiposAlimentos(){
    }

    public TiposAlimentos(long id_Alimentos, String alimentos) {
        this.id_Alimentos = id_Alimentos;
        this.Alimentos = alimentos;
    }

    //Getter e Setter

    public long getId_Alimentos() {
        return id_Alimentos;
    }

    public void setId_Alimentos(long id_Alimentos) {
        this.id_Alimentos = id_Alimentos;
    }

    public String getAlimentos() {
        return Alimentos;
    }

    public void setAlimentos(String alimentos) {
        this.Alimentos = alimentos;
    }

    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaTiposAlimentos.CAMPO_Alimentos,Alimentos );
        return valores;
    }

    //função estática que permita obter um objeto a partir de um cursor
    public static TiposAlimentos fromCursor(Cursor cursor) {
        long id_Alimentos = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposBebidas.ID)
        );

        String Alimentos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposBebidas.CAMPO_Bebidas)
        );

        TiposAlimentos alimentos = new TiposAlimentos();

        alimentos.setId_Alimentos(id_Alimentos);
        alimentos.setAlimentos(Alimentos);

        return alimentos;

    }
}


