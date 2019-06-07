package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposAlimentos {
    long id_Alimentos;
    private String Alimentos;
    private String DescricaoAlimentos;
    private String nomeCategoria;


    //Construtores
    public TiposAlimentos(){
    }

    public TiposAlimentos(long id_Alimentos, String alimentos, String descricaoAlimentos, String nomeCategoria) {
        this.id_Alimentos = id_Alimentos;
        this.Alimentos = alimentos;
        this.DescricaoAlimentos = descricaoAlimentos;
        this.nomeCategoria = nomeCategoria;
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
    public String getDescricaoAlimentos() {
        return DescricaoAlimentos;
    }
    public void setDescricaoAlimentos(String descricaoAlimentos) {
        this.DescricaoAlimentos = descricaoAlimentos;
    }
    public String getNomeCategoria() {
        return nomeCategoria;
    }



    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaTiposAlimentos.CAMPO_Alimentos,Alimentos );
        valores.put(BdTabelaTiposAlimentos.CAMPO_DescricaoAliemtos,DescricaoAlimentos );

        return valores;
    }

    //função estática que permita obter um objeto a partir de um cursor
    public static TiposAlimentos fromCursor(Cursor cursor) {
        long id_Alimentos = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.ID)
        );

        String Alimentos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_Alimentos)
        );
        String DescricaoAlimentos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_DescricaoAliemtos)
        );
        String nomeCategoria = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_NOME_CATEGORIA_Alimentos)
        );



        TiposAlimentos alimentos = new TiposAlimentos();

        alimentos.setId_Alimentos(id_Alimentos);
        alimentos.setAlimentos(Alimentos);
        alimentos.setDescricaoAlimentos(DescricaoAlimentos);
        alimentos.nomeCategoria = nomeCategoria;


        return alimentos;

    }
}


