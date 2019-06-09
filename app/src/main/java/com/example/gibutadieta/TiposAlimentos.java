package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TiposAlimentos {

    private long id;
    private String Alimentos;
    private String DescricaoAlimentos;
    private String nomeCategoria;


    //Getter e Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTiposAlimentos._ID)
        );

        String Alimentos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_Alimentos)
        );
        String DescricaoAlimentos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_DescricaoAliemtos)
        );
        //String nomeCategoria = cursor.getString(
                //cursor.getColumnIndex(BdTabelaTiposAlimentos.CAMPO_NOME_CATEGORIA_Alimentos)
        //);



        TiposAlimentos alimentos = new TiposAlimentos();

        alimentos.setId(id);
        alimentos.setAlimentos(Alimentos);
        alimentos.setDescricaoAlimentos(DescricaoAlimentos);
        //alimentos.nomeCategoria = nomeCategoria;


        return alimentos;

    }
}


