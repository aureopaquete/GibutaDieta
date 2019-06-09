package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposBebidas {
    private long id;
    private String Bebidas;
    private String DescricaoBebidas;
    private String nomeCategoriaBebida;


    //Getter e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBebidas() {
        return Bebidas;
    }

    public void setBebidas(String bebidas) {
        this.Bebidas = bebidas;
    }

    public String getDescricaoBebidas() {
        return DescricaoBebidas;
    }

    public void setDescricaoBebidas(String descricaoBebidas) {
        this.DescricaoBebidas = descricaoBebidas;
    }

    public String getNomeCategoriaBebida() {
        return nomeCategoriaBebida;
    }

    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaTiposBebidas.CAMPO_Bebidas, Bebidas);
        valores.put(BdTabelaTiposBebidas.CAMPO_DescricaoBebidas,DescricaoBebidas );

        return valores;
    }

    //função estática que permita obter um objeto a partir de um cursor
    public static TiposBebidas fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposBebidas._ID)
        );

        String Bebidas = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposBebidas.CAMPO_Bebidas)
        );
        String DescricaoBebidas = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposBebidas.CAMPO_DescricaoBebidas)
        );
        String nomeCategoriaBebida = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposBebidas.CAMPO_NOME_CATEGORIA_Bebidas)
        );

      TiposBebidas bebidas = new TiposBebidas();

        bebidas.setId(id);
        bebidas.setBebidas(Bebidas);
        bebidas.setDescricaoBebidas(DescricaoBebidas);
        bebidas.nomeCategoriaBebida = nomeCategoriaBebida;

        return bebidas;

    }

}


