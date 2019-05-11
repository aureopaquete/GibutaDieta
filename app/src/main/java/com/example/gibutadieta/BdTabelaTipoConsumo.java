package com.example.gibutadieta;

import android.database.sqlite.SQLiteDatabase;

public class BdTabelaTipoConsumo {

    public static final  String NOME_TABELA = "Tipos de Consumo";

    public static final  String ID = "ID_CONSUMO";
    public static final  String CAMPO_AGUA = "AGUA";
    public static final  String CAMPO_CARBOIDRATO = "CARBOIDRATO";
    public static final  String CAMPO_VEGETAIS = "VEGETAIS";
    public static final  String CAMPO_PROTEINAS = "PROTEINAS";

    public  static final  String[] TODAS_COLUNAS = new String[] { ID,CAMPO_AGUA,CAMPO_CARBOIDRATO,CAMPO_VEGETAIS,CAMPO_PROTEINAS };

    private SQLiteDatabase db;

    public BdTabelaTipoConsumo(SQLiteDatabase db){this.db = db;}

    public void cria (){
        db.execSQL( "CREATE TABLE " + NOME_TABELA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_AGUA + " TEXT NOT NULL," +
                CAMPO_CARBOIDRATO+ " INTEGER NOT NULL," +
                CAMPO_PROTEINAS + " INTEGER NOT NULL," +
                CAMPO_VEGETAIS + " INTEGER NOT NULL," +
                ")"
        );
    }

}
