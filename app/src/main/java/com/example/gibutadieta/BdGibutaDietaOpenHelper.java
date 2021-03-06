package com.example.gibutadieta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BdGibutaDietaOpenHelper extends SQLiteOpenHelper {

    public static final String NOME_BASE_DADOS = "GibutaDieta.db";
    public static final int VERSAO_BASE_DADOS = 1;

    //Construtor Defaul
    public BdGibutaDietaOpenHelper(@Nullable Context context){
        super(context, NOME_BASE_DADOS, null, VERSAO_BASE_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        new BdTabelaTiposBebidas(db).cria();
        new BdTabelaTiposAlimentos(db).cria();
        new BdTabelaQuantidade(db).cria();


}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
