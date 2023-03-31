package br.com.gerenciador;


import java.util.ArrayList;
import java.util.List;

import br.com.caminhao.Caminhao;
import br.com.transporte.Transporte;
import br.com.trecho.ModalidadeTransporte;

public class GerenciadorTransporte {
    private List<Transporte> transportadoras;

    public GerenciadorTransporte() {
        this.transportadoras = new ArrayList<>();
    }

    public void cadastrarTransportadora(String nome, ModalidadeTransporte modalidade) {
        Transporte transportadora = new Transporte(nome, modalidade);
        transportadoras.add(transportadora);
        System.out.println("Transportadora " + nome + " cadastrada com sucesso.");
    }

    public List<Transporte> buscarTransportadorasPorModalidade(ModalidadeTransporte modalidade) {
        List<Transporte> transportadorasEncontradas = new ArrayList<>();
        for (Transporte transportadora : transportadoras) {
            if (transportadora.getModalidade().equals(modalidade)) {
                transportadorasEncontradas.add(transportadora);
            }
        }
        return transportadorasEncontradas;
    }

    public void removerTransportadora(String nome) {
        for (int i = 0; i < transportadoras.size(); i++) {
            if (transportadoras.get(i).getNome().equals(nome)) {
                transportadoras.remove(i);
                System.out.println("Transportadora " + nome + " removida com sucesso.");
                return;
            }
        }
        System.out.println("Não foi encontrada nenhuma transportadora com o nome " + nome);
    }

    public void listarTransportadoras() {
        System.out.println("Transportadoras cadastradas:");
        for (Transporte transportadora : transportadoras) {
            System.out.println("- " + transportadora.getCusto() + " (" + transportadora.getOrigem() + ")");
        }
    }

	public List<Caminhao> getCaminhoesDisponiveis(double pesoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cadastrarProduto(String string, int i) {
		// TODO Auto-generated method stub
		
	}

	public Object gerarRelatorio() {
		return gerarRelatorio();
		
	}
}