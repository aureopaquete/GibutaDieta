package com.example.gibutadieta;

public class TabCarbo {

    int id;
    int Quantidade;


    //Construtor


    public TabCarbo() {
    }

    public TabCarbo(int id, int quantidade) {
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
