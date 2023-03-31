package br.com.transporte;
import java.util.ArrayList;
import java.util.List;

import br.com.caminhao.Caminhao;
import br.com.cidade.Cidade;
import br.com.itemtransporte.ItemTransporte;
import br.com.trecho.ModalidadeTransporte;
import br.com.trecho.Trecho;

public class Transporte {
    private Cidade origem;
    private Cidade destino;
    private List<ItemTransporte> itensTransporte;
	private Cidade cidadeOrigem;
	private Cidade cidadeDestino;
	private double distancia;
	private List<Caminhao> caminhoesDisponiveis;
	private double custo;

    public Transporte(Cidade origem, Cidade destino) {
        this.origem = origem;
        this.destino = destino;
        this.itensTransporte = new ArrayList<>();
    }

    public Transporte(String nome, ModalidadeTransporte modalidade) {
		// TODO Auto-generated constructor stub
	}

	public void adicionarItemTransporte(ItemTransporte item) {
        this.itensTransporte.add(item);
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public List<ItemTransporte> getItensTransporte() {
        return itensTransporte;
    }

    // 

    
    
    public void setItensTransporte(List<ItemTransporte> itensTransporte) {
        this.itensTransporte = itensTransporte;
    }
    
    public Cidade getCidadeOrigem() {
        return getCidadeOrigem();
    }
    
    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }
    
    public Cidade getCidadeDestino() {
        return getCidadeDestino();
    }
    
    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }
    
    public double getDistancia() {
        return getDistancia();
    }
    
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public List<Caminhao> getCaminhoesDisponiveis() {
        return getCaminhoesDisponiveis();
    }
    
    public void setCaminhoesDisponiveis(List<Caminhao> caminhoesDisponiveis) {
        this.caminhoesDisponiveis = caminhoesDisponiveis;
    }
    
    public void calcularDistanciaTotal() {
        double distanciaTotal = 0;
        Cidade cidadeAtual = cidadeOrigem;
    
        Trecho[] trechos = null;
		for (Trecho trecho : trechos) {
            if (trecho.getOrigem().equals(cidadeAtual)) {
                distanciaTotal += trecho.getDistancia();
                cidadeAtual = trecho.getDestino();
            }
        }
    
        this.distancia = distanciaTotal;
    }
    
    public void calcularCustoTotal() {
        double custoTotal = 0;
    
        Trecho[] trechos = null;
		for (Trecho trecho : trechos) {
            custoTotal += trecho.getCusto();
        }
    
        this.custo = custoTotal;
    }
    
    public List<Caminhao> calcularCaminhoesNecessarios() {
        List<Caminhao> caminhoesNecessarios = new ArrayList<>();
        double pesoTotal = 0;
    
        for (ItemTransporte item : itensTransporte) {
            pesoTotal += item.getPeso();
        }
    
        for (Caminhao caminhao : caminhoesDisponiveis) {
            if (pesoTotal <= caminhao.getCapacidade()) {
                caminhoesNecessarios.add(caminhao);
                break;
            }
        }
		return caminhoesNecessarios;
    }

	public double getCusto() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

	