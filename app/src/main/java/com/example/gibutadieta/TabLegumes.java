package com.example.gibutadieta;

public class TabLegumes {

    int id;
    int Quantidade;


    //Construtor


    public TabLegumes() {
    }

    public TabLegumes(int id, int quantidade) {
        this.id = id;
        this.Quantidade = quantidade;
    }

    //Métodos Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }
}
