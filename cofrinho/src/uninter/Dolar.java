package uninter;

public class Dolar extends Moeda {

	public Dolar(double valorInicial) {
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Dolar - " + valor);
	}

	@Override
	public double converter() {
		return this.valor * 5.11; // Cotação do dólar hoje
	}

	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}

		Dolar objetoDeDolar = (Dolar) objeto;

		if (this.valor != objetoDeDolar.valor) {
			return false;
		}

		return true;
	}

}