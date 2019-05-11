package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;
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

    //Criação da Tabela
    public void cria (){
        db.execSQL( "CREATE TABLE " + NOME_TABELA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_AGUA + " INTEGER NOT NULL," +
                CAMPO_CARBOIDRATO+ " INTEGER NOT NULL," +
                CAMPO_PROTEINAS + " INTEGER NOT NULL," +
                CAMPO_VEGETAIS + " INTEGER NOT NULL," +
                ")"
        );
    }

    //CRUD

    //create
    public long insert(ContentValues values){
        return db.insert(NOME_TABELA, null, values);
    }

    //update
    public int update(ContentValues values, String whereClause, String[] whereArgs){
        return db.update(NOME_TABELA,values,whereClause,whereArgs);
    }

    //delete
    public int delete(String whereClause, String[] whereArgs){
        return db.delete(NOME_TABELA,whereClause,whereArgs);
    }

    //read
    public Cursor query (String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

}
