package br.com.custotrecho;

import br.com.caminhao.Caminhao;
import br.com.trecho.Trecho;

public class CustoTrecho {
    private Trecho trecho;
    private Caminhao caminhao;
    private double custo;

    public CustoTrecho(Trecho trecho, Caminhao caminhao, double custo) {
        this.trecho = trecho;
        this.caminhao = caminhao;
        this.custo = custo;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public double getCusto() {
        return custo;
    }
}
