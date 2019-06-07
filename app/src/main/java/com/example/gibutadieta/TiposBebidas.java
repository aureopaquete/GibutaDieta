package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposBebidas {
    long id_Bebidas;
    private String Bebidas;
    private String DescricaoBebidas;
    private String nomeCategoriaBebida;

    //Construtores
    public TiposBebidas(){
    }
    public TiposBebidas(long id_Bebidas, String bebidas, String descricaoBebidas, String nomeCategoriaBebida) {
        this.id_Bebidas = id_Bebidas;
        this.Bebidas = bebidas;
        this.DescricaoBebidas = descricaoBebidas;
        this.nomeCategoriaBebida = nomeCategoriaBebida;
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

    public String getDescricaoBebidas() {
        return DescricaoBebidas;
    }

    public void setDescricaoBebidas(String descricaoBebidas) {
        DescricaoBebidas = descricaoBebidas;
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
        long id_Bebidas = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposBebidas.ID)
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

        bebidas.setId_Bebidas(id_Bebidas);
        bebidas.setBebidas(Bebidas);
        bebidas.setDescricaoBebidas(DescricaoBebidas);
        bebidas.nomeCategoriaBebida = nomeCategoriaBebida;

        return bebidas;

    }

}


