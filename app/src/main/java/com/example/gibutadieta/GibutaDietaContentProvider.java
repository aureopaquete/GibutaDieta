package com.example.gibutadieta;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class GibutaDietaContentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.gibutadieta";
    public static final String ALIMENTOS = "alimentos";
    public static final String BEBIDAS = "bebidas";


    private static final Uri ENDERECO_BASE = Uri.parse("content://" + AUTHORITY);
    public static final Uri ENDERECO_CATEGORIAS = Uri.withAppendedPath(ENDERECO_BASE, ALIMENTOS);
    public static final Uri ENDERECO_LIVROS = Uri.withAppendedPath(ENDERECO_BASE, BEBIDAS);

    public static final int URI_ALIMENTOS = 100;
    public static final int URI_ALIMENTO_ESPECIFICO = 101;
    public static final int URI_BEBIDAS = 200;
    public static final int URI_BEBIDAS_ESPECIFICA = 201;

    public static final String UNICO_ITEM = "vnd.android.cursor.item/";
    public static final String MULTIPLOS_ITEMS = "vnd.android.cursor.dir/";

    private BdGibutaDietaOpenHelper bdGibutaDietaOpenHelper;

    private UriMatcher getUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTHORITY, ALIMENTOS, URI_ALIMENTO_ESPECIFICO);
        uriMatcher.addURI(AUTHORITY, ALIMENTOS + "/#", URI_ALIMENTO_ESPECIFICO);
        uriMatcher.addURI(AUTHORITY, BEBIDAS, URI_BEBIDAS);
        uriMatcher.addURI(AUTHORITY, BEBIDAS + "/#", URI_BEBIDAS_ESPECIFICA);

        return uriMatcher;
    }


    @Override
    public boolean onCreate() {
        bdGibutaDietaOpenHelper = new BdGibutaDietaOpenHelper(getContext());
        return true;
    }


    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {


        SQLiteDatabase bd = bdGibutaDietaOpenHelper.getReadableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)) {
            case URI_ALIMENTOS:
                return new BdTabelaTiposAlimentos(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ALIMENTO_ESPECIFICO:
                return new BdTabelaTiposAlimentos(bd).query(projection, BdTabelaTiposAlimentos._ID + "=?", new String[] { id }, null, null, null);

            case URI_BEBIDAS:
                return new BdTabelaTiposBebidas(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_BEBIDAS_ESPECIFICA:
                return  new BdTabelaTiposBebidas(bd).query(projection, BdTabelaTiposBebidas._ID + "=?", new String[] { id }, null, null, null);

            default:
                throw new UnsupportedOperationException("URI inválida (QUERY): " + uri.toString());
        }
    }


    @Override
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    @NonNull
    public Uri insert( @NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
