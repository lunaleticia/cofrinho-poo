package uninter;

public class Euro extends Moeda {

	public Euro(double valorInicial) {
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Euro - " + valor);
	}

	@Override
	public double converter() {
		return this.valor * 5.55; // Cotação do euro hoje
	}

	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}

		Euro objetoDeEuro = (Euro) objeto;

		if (this.valor != objetoDeEuro.valor) {
			return false;
		}

		return true;
	}

}