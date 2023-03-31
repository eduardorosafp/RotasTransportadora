//package br.com.relatoriotransporte;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import br.com.caminhao.Caminhao;
//import br.com.itemtransporte.ItemTransporte;
//import br.com.transporte.Transporte;
//import br.com.trecho.Trecho;
//
//public class RelatorioTransporte {
//	private List<Transporte> transportes;
//
//	public RelatorioTransporte(List<Transporte> transportes) {
//		this.transportes = transportes;
//	}
//
//	public void gerarRelatorio() {
//		double custoTotalGeral = 0;
//		double distanciaTotalGeral = 0;
//		int numVeiculosDeslocados = 0;
//		int numItensTransportados = 0;
//		Map<String, Double> custoPorModalidade = new HashMap<>();
//		Map<String, Integer> numVeiculosPorModalidade = new HashMap<>();
//		Map<String, Integer> numItensPorTipo = new HashMap<>();
//
//		for (Transporte transporte : transportes) {
//			double custoTotalTransporte = transporte.getCusto();
//			double distanciaTotalTransporte = transporte.getDistancia();
//			int numVeiculosTransporte = transporte.getCaminhoesDisponiveis().size();
//			int numItensTransporte = transporte.getItensTransporte().size();
//
//			// Custo médio por km
//			double custoMedioKm = custoTotalTransporte / distanciaTotalTransporte;
//
//			// Custo médio por tipo de produto
//			for (ItemTransporte item : transporte.getItensTransporte()) {
//				String tipo = item.getPeso().getTipo();
//				double custoItem = item.getValor();
//				if (numItensPorTipo.containsKey(tipo)) {
//					int numItens = numItensPorTipo.get(tipo);
//					numItensPorTipo.put(tipo, numItens + 1);
//					double custoTotalTipo = custoPorModalidade.get(tipo);
//					custoPorModalidade.put(tipo, custoTotalTipo + custoItem);
//				} else {
//					numItensPorTipo.put(tipo, 1);
//					custoPorModalidade.put(tipo, custoItem);
//				}
//			}
//
//			// Custo por trecho
//			Map<String, Double> custoPorTrecho = new HashMap<>();
//			for (Trecho trecho : transporte.getTrechos()) {
//				String origem = trecho.getCidadeOrigem().getNome();
//				String destino = trecho.getCidadeDestino().getNome();
//				double custoTrecho = trecho.getCusto();
//				String chaveTrecho = origem + " - " + destino;
//				if (custoPorTrecho.containsKey(chaveTrecho)) {
//					double custoTotalTrecho = custoPorTrecho.get(chaveTrecho);
//					custoPorTrecho.put(chaveTrecho, custoTotalTrecho + custoTrecho);
//				} else {
//					custoPorTrecho.put(chaveTrecho, custoTrecho);
//				}
//			}
//
//			// Custo total por trecho
//			double custoTotalTrecho = 0;
//			for (Double custo : custoPorTrecho.values()) {
//				custoTotalTrecho += custo;
//			}
//
//			// Custo total por modalidade
//			for (Caminhao caminhao : transporte.getCaminhoesDisponiveis()) {
//				String modalidade = caminhao.getModalidade();
//				double custoCaminhao = custoTotalTransporte / numVeiculosTransporte;
//				if (custoPorModalidadecontainsKey(modalidade)) {
//					double custoTotalModalidade = custoPorModalidade.get(modalidade);
//					custoPorModalidade.put(modalidade, custoTotalModalidade + custoCaminhao);
//					int numVeiculos = numVeiculosPorModalidade.get(modalidade);
//					numVeiculosPorModalidade.put(modalidade, numVeiculos + 1);
//				} else {
//					custoPorModalidade.put(modalidade, custoCaminhao);
//					numVeiculosPorModalidade.put(modalidade, 1);
//				}
//			}
//			// Imprimir o relatório do transporte
//			System.out.println("Transporte ID: " + transporte.getId());
//			System.out.println("Custo total: " + custoTotalTransporte);
//			System.out.println("Custo por trecho:");
//			for (String chave : custoPorTrecho.keySet()) {
//				System.out.println(chave + ": " + custoPorTrecho.get(chave));
//			}
//			System.out.println("Custo médio por km: " + custoMedioKm);
//			System.out.println("Custo médio por tipo de produto:");
//			for (String tipo : numItensPorTipo.keySet()) {
//				double custoTotalTipo = custoPorModalidade.get(tipo);
//				int numItens = numItensPorTipo.get(tipo);
//				double custoMedioTipo = custoTotalTipo / numItens;
//				System.out.println(tipo + ": " + custoMedioTipo);
//			}
//			System.out.println("Custo total por trecho: " + custoTotalTrecho);
//			System.out.println("Custo total por modalidade de transporte:");
//			for (String modalidade : custoPorModalidade.keySet()) {
//				System.out.println(modalidade + ": " + custoPorModalidade.get(modalidade));
//			}
//			System.out.println("Número total de veículos deslocados: " + numVeiculosTransporte);
//			System.out.println("Número total de itens transportados: " + numItensTransporte);
//			System.out.println("--------------------");
//		}
//
//		// Imprimir o relatório geral
//		System.out.println("Relatório geral:");
//		System.out.println("Custo total geral: " + custoTotalGeral);
//		System.out.println("Custo médio por km geral: " + custoTotalGeral / distanciaTotalGeral);
//		System.out.println("Custo total por modalidade de transporte geral:");
//		for (String modalidade : custoPorModalidade.keySet()) {
//			System.out.println(modalidade + ": " + custoPorModalidade.get(modalidade));
//		}
//		System.out.println("Número total de veículos deslocados geral: " + numVeiculosDeslocados);
//		System.out.println("Número total de itens transportados geral: " + numItensTransportados);
//	}
//}
// 