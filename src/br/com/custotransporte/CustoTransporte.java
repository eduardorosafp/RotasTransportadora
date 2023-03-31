package br.com.custotransporte;

import java.util.ArrayList;
import java.util.List;

import br.com.caminhao.Caminhao;
import br.com.custotrecho.CustoTrecho;

public class CustoTransporte {
    private List<CustoTrecho> custosTrechos;
    private List<Caminhao> caminhoesDisponiveis;

    public CustoTransporte(List<Caminhao> caminhoesDisponiveis) {
        this.custosTrechos = new ArrayList<>();
        this.caminhoesDisponiveis = caminhoesDisponiveis;
    }

    public void adicionarCustoTrecho(CustoTrecho custoTrecho) {
        this.custosTrechos.add(custoTrecho);
    }

    public double getCustoTotal() {
        double custoTotal = 0;
        for (CustoTrecho custoTrecho : custosTrechos) {
            custoTotal += custoTrecho.getCusto();
        }
        return custoTotal;
        }
        }
    
