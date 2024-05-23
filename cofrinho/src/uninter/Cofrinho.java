package uninter;

import java.util.ArrayList;

public class Cofrinho {

	private ArrayList<Moeda> listaMoedas;

	public Cofrinho() {
		this.listaMoedas = new ArrayList<>();
	}

	public void adicionar(Moeda moeda) {
		this.listaMoedas.add(moeda);
	}

	// Remove uma moeda da lista
	public void remover(Moeda moeda) {
		this.listaMoedas.remove(moeda);
	}

	public void listagemMoedas() {

		// Verifica se a lista está vazia
		if (this.listaMoedas.isEmpty()) {
			System.out.println("Não existe Moedas no cofrinho!");
			return;
		}

		for (Moeda moeda : this.listaMoedas) {
			moeda.info();
		}

	}

	public double totalConvertido() {

		if (this.listaMoedas.isEmpty()) {
			return 0;
		}

		double valorAcumulado = 0;

		for (Moeda moeda : this.listaMoedas) {
			valorAcumulado = valorAcumulado + moeda.converter(); // Acumula o valor convertido de cada moeda
		}

		return valorAcumulado; // Retorna o valor total convertido

	}

}