package br.com.itemtransporte;

public class ItemTransporte {
    private String nome;
    private double peso;

    public ItemTransporte(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
}
