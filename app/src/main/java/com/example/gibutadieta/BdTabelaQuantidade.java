package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTabelaQuantidade implements BaseColumns {

    public static final  String NOME_TABELA = "QUANTIDADE";

    public static final  String CAMPO_QUANTIDADE = "QUANTIDADE_PRODUTO";

    public static final  String[] TODAS_COLUNAS = new String[] { _ID,CAMPO_QUANTIDADE};


    private SQLiteDatabase db;

    public BdTabelaQuantidade(SQLiteDatabase db){this.db = db;}

    //Criação da tabela
    public void cria (){
        db.execSQL( "CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_QUANTIDADE + " INTEGER NOT NULL," +
                "FOREIGN KEY (" + CAMPO_QUANTIDADE + ") REFERENCES " + BdTabelaTiposAlimentos.NOME_TABELA + "(" + BdTabelaTiposAlimentos._ID + "), " +
                "FOREIGN KEY (" + CAMPO_QUANTIDADE + ") REFERENCES " + BdTabelaTiposBebidas.NOME_TABELA + "(" + BdTabelaTiposBebidas._ID + ")" +
                ")"
        );
    }

    //CRUD

    //read
    public Cursor query (String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
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
}



