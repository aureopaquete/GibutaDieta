package com.example.gibutadieta;

import android.content.ContentValues;
import android.database.Cursor;

public class TipoConsumo {
    long id_Consumo;
    private String Agua;
    private String Caboidratos;
    private String Vegetais;
    private String Proteinas;

    //Construtores
    public TipoConsumo(){
    }

    public TipoConsumo(int id_Consumo, String agua, String caboidratos, String vegetais, String proteinas) {
        this.id_Consumo = id_Consumo;
        this.Agua = agua;
        this.Caboidratos = caboidratos;
        this.Vegetais = vegetais;
        this.Proteinas = proteinas;
    }


    //Getter e Setter
    public long getId_Consumo() {
        return id_Consumo;
    }

    public void setId_Consumo(long id_Consumo) {
        this.id_Consumo = id_Consumo;
    }

    public String getAgua() {
        return Agua;
    }

    public void setAgua(String agua) {
        this.Agua = agua;
    }

    public String getCaboidratos() {
        return Caboidratos;
    }

    public void setCaboidratos(String caboidratos) {
        this.Caboidratos = caboidratos;
    }

    public String getVegetais() {
        return Vegetais;
    }

    public void setVegetais(String vegetais) {
        this.Vegetais = vegetais;
    }

    public String getProteinas() {
        return Proteinas;
    }

    public void setProteinas(String proteinas) {
        this.Proteinas = proteinas;
    }


    // Funções getContentValues
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTabelaTipoConsumo.CAMPO_AGUA, Agua);
        valores.put(BdTabelaTipoConsumo.CAMPO_CARBOIDRATO, Caboidratos);
        valores.put(BdTabelaTipoConsumo.CAMPO_VEGETAIS, Vegetais);
        valores.put(BdTabelaTipoConsumo.CAMPO_PROTEINAS, Proteinas);

        return valores;
    }

    public static TipoConsumo fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTabelaTipoConsumo.ID)
        );

        String agua = cursor.getString(
                cursor.getColumnIndex(BdTabelaTipoConsumo.CAMPO_AGUA)
        );

        String carboidratos = cursor.getString(
                cursor.getColumnIndex(BdTabelaTipoConsumo.CAMPO_CARBOIDRATO)
        );

        String proteinas = cursor.getString(
                cursor.getColumnIndex(BdTabelaTipoConsumo.CAMPO_PROTEINAS)
        );

        String vegetais = cursor.getString(
                cursor.getColumnIndex(BdTabelaTipoConsumo.CAMPO_VEGETAIS)
        );

        TipoConsumo tipoConsumo = new TipoConsumo();

        tipoConsumo.setId_Consumo(id);
        tipoConsumo.setAgua(agua);
        tipoConsumo.setCaboidratos(carboidratos);
        tipoConsumo.setProteinas(proteinas);
        tipoConsumo.setVegetais(vegetais);

        return tipoConsumo;
    }
}


