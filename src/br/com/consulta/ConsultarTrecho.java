package br.com.consulta;


import java.util.ArrayList;
import java.util.List;

import br.com.cidade.Cidade;
import br.com.trecho.ModalidadeTransporte;
import br.com.trecho.Trecho;

public class ConsultarTrecho {

    private List<Trecho> trechos;

    public ConsultarTrecho(List<Trecho> trechos) {
        this.trechos = trechos;
    }

    public List<Trecho> consultarPorOrigemDestinoModalidade(Cidade origem, Cidade destino, ModalidadeTransporte modalidade) {
        List<Trecho> resultado = new ArrayList<>();

        for (Trecho trecho : trechos) {
            if (trecho.getOrigem().equals(origem) &&
                trecho.getDestino().equals(destino) &&
                trecho.getModalidade().equals(modalidade)) {
                resultado.add(trecho);
            }
        }

        return resultado;
    }

    public List<Trecho> consultarPorOrigemDestino(Cidade origem, Cidade destino) {
        List<Trecho> resultado = new ArrayList<>();

        for (Trecho trecho : trechos) {
            if (trecho.getOrigem().equals(origem) &&
                trecho.getDestino().equals(destino)) {
                resultado.add(trecho);
            }
        }

        return resultado;
    }

    public List<ModalidadeTransporte> modalidadesDisponiveis() {
        List<ModalidadeTransporte> modalidades = new ArrayList<>();

        for (Trecho trecho : trechos) {
            ModalidadeTransporte modalidade = trecho.getModalidade();
            if (!modalidades.contains(modalidade)) {
                modalidades.add(modalidade);
            }
        }

        return modalidades;
    }
}
