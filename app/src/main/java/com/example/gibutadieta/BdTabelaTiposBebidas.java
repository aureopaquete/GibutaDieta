package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTabelaTiposBebidas implements BaseColumns {

    public static final String NOME_TABELA = "TiposBebidas";
    public static final String NOME_CATEGORIA_Bebidas = "ElementoSpinner";

    public static final String ID = "ID_Bebidas";
    public static final String CAMPO_Bebidas = "Bebidas";
    public static final  String CAMPO_DescricaoBebidas = "DescricaoBebidas";
    public static final  String CAMPO_NOME_CATEGORIA_Bebidas = BdTabelaQuantidade.NOME_TABELA + "." + BdTabelaQuantidade.CAMPO_QUANTIDADE + " AS " + NOME_CATEGORIA_Bebidas; // tabela de categorias (só de leitura)


    public static final String[] TODAS_COLUNAS = new String[] { ID,CAMPO_Bebidas,CAMPO_NOME_CATEGORIA_Bebidas};

    private SQLiteDatabase db;

    public BdTabelaTiposBebidas(SQLiteDatabase db){this.db = db;}

    //Criação da tabela
    public void cria (){
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_DescricaoBebidas + " TEXT NOT NULL," +
                CAMPO_Bebidas + " TEXT NOT NULL)"
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
