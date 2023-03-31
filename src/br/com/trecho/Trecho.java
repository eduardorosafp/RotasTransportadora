package br.com.trecho;

import br.com.cidade.Cidade;

public class Trecho {
    private Cidade origem;
    private Cidade destino;
    private double distancia;
    private ModalidadeTransporte transporte;
    private double custo;
	private ModalidadeTransporte modalidade;

    public Trecho(Cidade origem, Cidade destino, double distancia, ModalidadeTransporte modalidade, double custo) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.modalidade = modalidade;
        this.custo = custo;
    }

    public Trecho(Cidade origem2, Cidade destino2, int distancia2, String string, int custo2) {
		// TODO Auto-generated constructor stub
	}

	public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public ModalidadeTransporte getModalidade() {
        return modalidade;
    }

    public double getCusto() {
        return custo;
    }
}

