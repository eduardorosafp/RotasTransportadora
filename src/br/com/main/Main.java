package br.com.main;

import java.util.List;
import java.util.Scanner;

import br.com.caminhao.Caminhao;
import br.com.cidade.Cidade;
import br.com.consulta.ConsultarTrecho;
import br.com.gerenciador.GerenciadorTransporte;
import br.com.itemtransporte.ItemTransporte;
import br.com.trecho.ModalidadeTransporte;
import br.com.trecho.Trecho;

public class Main {
	public static void main(String[] args) {
		// Inicializa o array de objetos Cidade
		Cidade[] cidades = { new Cidade("Porto Alegre", -30.027704, -51.228735),
				new Cidade("S�o Paulo", -23.550520, -46.633309), new Cidade("Rio de Janeiro", -22.906847, -43.172897),
				new Cidade("Belo Horizonte", -19.916681, -43.934493)
				// Adicionar outras cidades aqui, se necess�rio
		};

		// Inicializa o array de objetos Trecho
		Trecho[] trechos = { new Trecho(cidades[0], cidades[1], 850, "caminh�o pequeno", 800),
				new Trecho(cidades[0], cidades[2], 1540, "caminh�o pequeno", 1200),
				new Trecho(cidades[0], cidades[3], 1980, "caminh�o pequeno", 1500),
				new Trecho(cidades[1], cidades[2], 430, "caminh�o pequeno", 500),
				new Trecho(cidades[1], cidades[3], 1010, "caminh�o pequeno", 800),
				new Trecho(cidades[2], cidades[3], 340, "caminh�o pequeno", 400)
				// Adicionar outros trechos aqui, se necess�rio
		};
		
		
		
		// Inicializa o objeto GerenciadorTransporte
		GerenciadorTransporte gerenciador = new GerenciadorTransporte();

		// Cadastra alguns produtos
		gerenciador.cadastrarProduto("Leite em p�", 2000);
		gerenciador.cadastrarProduto("Arroz", 10000);
		gerenciador.cadastrarProduto("Feij�o", 8000);

		// Gera o relat�rio estat�stico
	      System.out.println("relatorio" + gerenciador.gerarRelatorio());	
	

		// Leitura dos dados do usu�rio
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o nome da cidade de origem: ");
		String nomeOrigem = scanner.nextLine();
		System.out.print("Digite o nome da cidade de destino: ");
		String nomeDestino = scanner.nextLine();
		System.out.print("Digite a modalidade de transporte (ex: caminh�o pequeno): ");
		String modalidadeTransporte = scanner.nextLine();
       
      // Busca das cidades de origem e destino
        Cidade cidadeOrigem = buscaCidade(nomeOrigem, cidades);
        Cidade cidadeDestino = buscaCidade(nomeDestino, cidades);
       
       // Verifica��o de cidades encontradas
      if (cidadeOrigem == null || cidadeDestino == null) {
            System.out.println("Uma ou ambas as cidades n�o foram encontradas.");
            return;
       }
       
        // Busca do trecho correspondente
        Trecho trecho = buscaTrecho(cidadeOrigem, cidadeDestino, modalidadeTransporte, trechos);
////        
       // Verifica��o de trecho encontrado
       if (trecho == null) {
           System.out.println("N�o existe trecho que satisfa�a os crit�rios informados.");
           return;
       }
       
       // C�lculo da dist�ncia rodovi�ria entre as cidades
       double distanciaRodoviaria = calculaDistanciaRodoviaria(cidadeOrigem, cidadeDestino);
       
       // C�lculo do custo total do trecho
        double custoTotal = trecho.getCusto();
       
      // Exibi��o das informa��es
      System.out.println("De " + cidadeOrigem.getNome() + " para " + cidadeDestino.getNome() + ", utilizando " + modalidadeTransporte + ", a dist�ncia � de " + distanciaRodoviaria + " km.");
             System.out.println("O custo total do trecho � de R$" + custoTotal + ".");

	}

	private static Cidade buscaCidade(String nomeOrigem, Cidade[] cidades) {
		// TODO Auto-generated method stub
		return null;
	}

	private static double calculaDistanciaRodoviaria(Cidade cidadeOrigem, Cidade cidadeDestino) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static Trecho buscaTrecho(Cidade cidadeOrigem, Cidade cidadeDestino, String modalidadeTransporte,
			Trecho[] trechos) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cidade buscarCidade(String nomeCidade) {
		Cidade[] cidades = null;
		for (Cidade cidade : cidades) {
			if (cidade.getNome().equalsIgnoreCase(nomeCidade)) {
				return cidade;
			}
		}
		return null;
	}

	public Trecho buscarTrecho(Cidade origem, Cidade destino, ModalidadeTransporte modalidade) {
		Trecho[] trechos = null;
		for (Trecho trecho : trechos) {
			if (trecho.getOrigem().equals(origem) && trecho.getDestino().equals(destino)
					&& trecho.getModalidade() == modalidade) {
				return trecho;
			}
		}
		return null;
	}

	public void realizarConsulta() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe a cidade de origem:");
		String nomeOrigem = scanner.nextLine();
		Cidade origem = buscarCidade(nomeOrigem);
		if (origem == null) {
			System.out.println("Cidade de origem n�o encontrada.");
			return;
		}
		System.out.println("Informe a cidade de destino:");
		String nomeDestino = scanner.nextLine();
		Cidade destino = buscarCidade(nomeDestino);
		if (destino == null) {
			System.out.println("Cidade de destino n�o encontrada.");
			return;
		}
		System.out.println("Informe a modalidade de transporte (caminh�o_pequeno, caminh�o_grande, carreta, van):");
		String nomeModalidade = scanner.nextLine();
		ModalidadeTransporte modalidade = ModalidadeTransporte.valueOf(nomeModalidade.toUpperCase());
		Trecho trecho = buscarTrecho(origem, destino, modalidade);
		if (trecho == null) {
			System.out.println("N�o existe trecho que satisfa�a os crit�rios informados.");
			return;
		}
		// System.out.printf("De %s para %s, utilizando %s, a dist�ncia � de %.2f km e o
		// custo ser� de R$ %.2f.\n", origem.getNome(), destino.getNome(),
		// modalidade.getNome(), trecho.getDistancia(), trecho.getCusto());
	}

	public void finalizarPrograma() {
		System.out.println("Programa finalizado. Obrigado por utilizar nosso servi�o!");
		System.exit(0);
	}

	public void executar() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - Realizar consulta");
			System.out.println("0 - Sair");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			case 1:
				realizarConsulta();
				break;
			case 0:
				finalizarPrograma();
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
		}
	}

	public void imprimirTrechosDisponiveis() {
		System.out.println("Trechos dispon�veis:");
		Trecho[] trechos = null;
		for (Trecho trecho : trechos) {
			System.out.printf("%s -> %s (%.2f km) - %s\n", trecho.getOrigem().getNome(), trecho.getDestino().getNome(),
					trecho.getDistancia(), trecho.getModalidade());
		}

		////////////

		Cidade[] cidades = null;
		// Exibe a lista de cidades dispon�veis
		listarCidadesDisponiveis(cidades);

		// Cria um scanner para ler os dados do produto a ser cadastrado
		Scanner scanner = new Scanner(System.in);

		// L� o nome do produto
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = scanner.nextLine();

		// L� o peso do produto
		System.out.print("Digite o peso do produto (em kg): ");
		double pesoProduto = scanner.nextDouble();

		// Cadastra o produto e obt�m a lista de caminh�es dispon�veis
		GerenciadorTransporte gerenciadorTransporte = new GerenciadorTransporte();
		List<Caminhao> caminhoesDisponiveis = gerenciadorTransporte.getCaminhoesDisponiveis(pesoProduto);

		// Exibe a lista de caminh�es dispon�veis
		if (caminhoesDisponiveis.isEmpty()) {
			System.out.println("N�o h� caminh�es dispon�veis para transportar esse produto.");
		} else {
			System.out.println("Caminh�es dispon�veis:");
			for (Caminhao caminhao : caminhoesDisponiveis) {
				System.out.println("- " + caminhao.getModelo());
			}
		}
	}

	private static void listarCidadesDisponiveis(Cidade[] cidades) {
		System.out.println("Cidades dispon�veis:");
		for (Cidade cidade : cidades) {
			System.out.println("- " + cidade.getNome());
		}

	}

}
