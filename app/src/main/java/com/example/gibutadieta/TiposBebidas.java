package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposBebidas {
    long id_Bebidas;
    private String Bebidas;

    //Construtores
    public TiposBebidas(){
    }

    public TiposBebidas(long id_Bebidas, String bebidas) {
        this.id_Bebidas = id_Bebidas;
        this.Bebidas = bebidas;
    }

    //Getter e Setter
    public long getId_Bebidas() {
        return id_Bebidas;
    }

    public void setId_Bebidas(long id_Bebidas) {
        this.id_Bebidas = id_Bebidas;
    }

    public String getBebidas() {
        return Bebidas;
    }

    public void setBebidas(String bebidas) {
        this.Bebidas = bebidas;
    }

    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaTiposBebidas.CAMPO_Bebidas, Bebidas);
        return valores;
    }

    //função estática que permita obter um objeto a partir de um cursor
    public static TiposBebidas fromCursor(Cursor cursor) {
        long id_Bebidas = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposBebidas.ID)
        );

        String Bebidas = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposBebidas.CAMPO_Bebidas)
        );

      TiposBebidas bebidas = new TiposBebidas();

        bebidas.setId_Bebidas(id_Bebidas);
        bebidas.setBebidas(Bebidas);

        return bebidas;

    }

}


