package br.com.caminhao;

public class Caminhao {
    private String modelo;
    private int capacidade;
    private double precoKmRodado;

    public Caminhao(String modelo, int capacidade, double precoKmRodado) {
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.precoKmRodado = precoKmRodado;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoKmRodado() {
        return precoKmRodado;
    }
}