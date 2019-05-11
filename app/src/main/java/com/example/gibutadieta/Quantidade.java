package com.example.gibutadieta;

import android.content.ContentValues;

public class Quantidade {
    private int id_Quantidade;
    private  String Quantidade;


    //Construtores
    public Quantidade(){
    }

    public Quantidade(int id_Quantidade, String quantidade) {
        this.id_Quantidade = id_Quantidade;
        Quantidade = quantidade;
    }


    //Getter e Setter
    public int getId_Quantidade() {
        return id_Quantidade;
    }

    public void setId_Quantidade(int id_Quantidade) {
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
}
