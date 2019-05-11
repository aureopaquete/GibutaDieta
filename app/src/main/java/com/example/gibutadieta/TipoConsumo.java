package com.example.gibutadieta;

import android.content.ContentValues;

public class TipoConsumo {
    int id_Consumo;
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
    public int getId_Consumo() {
        return id_Consumo;
    }

    public void setId_Consumo(int id_Consumo) {
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
}


