package uninter;

import java.util.Scanner;

public class Menu {

	private Scanner sc; // Scanner para entrada do usuário
	private Cofrinho cofrinho; // Instância de Cofrinho para gerenciar moedas

	public Menu() {
		sc = new Scanner(System.in); // Inicializa o Scanner
		cofrinho = new Cofrinho(); // Inicializa o Cofrinho
	}

	public void exibirMenuPrincipal() {
		// Exibe o menu principal
		System.out.println("COFRINHO:");
		System.out.println("1- Adicionar Moeda");
		System.out.println("2- Remover Moeda");
		System.out.println("3- Listar Moedas");
		System.out.println("4- Calcular total convertido para Real");
		System.out.println("0- Encerrar");

		// Lê a opção escolhida pelo usuário
		String opcao = sc.next();

		switch (opcao) {
		case "0":
			System.out.println("* Final do programa *");
			break;

		case "1":
			exibirMenuAdicionarMoeda(); // Exibe o Menu de adicionar moeda
			exibirMenuPrincipal(); // Retorna ao Menu Principal
			break;

		case "2":
			exibirMenuRemoverMoeda(); // Exibe o Menu de remover moeda
			exibirMenuPrincipal();

		case "3":
			cofrinho.listagemMoedas(); // Lista as moedas que tem no cofrinho
			exibirMenuPrincipal();
			break;

		case "4":
			// Calcula e exibe o total convertido para Real
			double valorTotalConvertido = cofrinho.totalConvertido();
			String valorTotalConvertidoTextual = String.format("%.2f", valorTotalConvertido);
			valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
			System.out.println("O Valor Total convertido para Real é: " + valorTotalConvertidoTextual);
			exibirMenuPrincipal();
			break;

		default:
			System.out.println("Opção inválida! Tente novamente.");
			exibirMenuPrincipal(); // Retorna ao Menu Principal em caso de opção inválida
			break;
		}

	}

	private void exibirMenuAdicionarMoeda() {
		// Exibe o submenu para adicionar moeda
		System.out.println("Escolha Moeda:");
		System.out.println("1 - Real:");
		System.out.println("2 - Dólar:");
		System.out.println("3 - Euro:");

		int opcaoMoeda = sc.nextInt();

		System.out.println("Digite o valor:");

		String valorTextualMoeda = sc.next(); // Lê o valor da moeda como String
		valorTextualMoeda = valorTextualMoeda.replace(",", "."); // Converte vírgula para ponto
		double valorMoeda = Double.parseDouble(valorTextualMoeda);

		Moeda moeda = null;

		// Instancia a moeda correspondente à opção escolhida
		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Ops! Essa Moeda não existe!");
			exibirMenuPrincipal();
		}

		cofrinho.adicionar(moeda); // Adiciona a moeda ao cofrinho
		System.out.println("-- Moeda adicionada --");
	}

	private void exibirMenuRemoverMoeda() {
		// Exibe o submenu para remover moeda
		System.out.println("Escolha Moeda:");
		System.out.println("1 - Real:");
		System.out.println("2 - Dólar:");
		System.out.println("3 - Euro:");

		int opcaoMoeda = sc.nextInt(); // Lê a opção de moeda escolhida

		System.out.println("Digite o valor:");

		String valorTextualMoeda = sc.next();
		valorTextualMoeda = valorTextualMoeda.replace(",", ".");
		double valorMoeda = Double.parseDouble(valorTextualMoeda);

		Moeda moeda = null;

		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Ops! Essa Moeda não existe!");
			exibirMenuPrincipal();
		}

		cofrinho.remover(moeda); // Remove a moeda do cofrinho
	}

}