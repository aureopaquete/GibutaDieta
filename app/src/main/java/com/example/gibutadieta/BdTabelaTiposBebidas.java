package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTabelaTiposBebidas implements BaseColumns {

    public static final String NOME_TABELA = "TiposBebidas";
    public static final String NOME_CATEGORIA_Bebidas = "Elemento_Spinner";

    public static final String CAMPO_Bebidas = "Bebidas";
    public static final String CAMPO_DescricaoBebidas = "DescricaoBebidas";
    public static final String CAMPO_NOME_CATEGORIA_Bebidas = "CATEGORIAS_BEBIDAS"; // tabela de categorias (só de leitura)


    public static final String[] TODAS_COLUNAS = new String[] {
            NOME_TABELA + "." + _ID, CAMPO_Bebidas, CAMPO_DescricaoBebidas};

    private SQLiteDatabase db;

    public BdTabelaTiposBebidas(SQLiteDatabase db){this.db = db;}

    //Criação da tabela
    public void cria (){
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_DescricaoBebidas + " TEXT NOT NULL," +
                CAMPO_Bebidas + " INTEGER NOT NULL)"
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
