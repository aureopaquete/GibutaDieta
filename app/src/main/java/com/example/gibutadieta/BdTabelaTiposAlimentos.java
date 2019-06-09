package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTabelaTiposAlimentos implements BaseColumns {

    public static final String NOME_TABELA = "TiposAlimentos";
    public static final String NOME_CATEGORIA_Alimentos = "Elemento_Spinner";

    public static final String CAMPO_Alimentos = "Alimentos";
    public static final String CAMPO_DescricaoAliemtos = "Descricao";
   // public static final String CAMPO_NOME_CATEGORIA_Alimentos = "CATEGORIAS_BEBIDAS"; // tabela de categorias (só de leitura)

    public static final String[] TODAS_COLUNAS = new String[] {
            NOME_TABELA + "." + _ID, CAMPO_Alimentos, CAMPO_DescricaoAliemtos };


    private SQLiteDatabase db;

    public BdTabelaTiposAlimentos(SQLiteDatabase db){this.db = db;}

    //Criação da Tabela
    public void cria (){
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_DescricaoAliemtos + " TEXT NOT NULL," +
                CAMPO_Alimentos + " INTEGER NOT NULL)"
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
