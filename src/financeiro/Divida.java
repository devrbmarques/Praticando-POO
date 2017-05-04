package financeiro;

import java.util.ArrayList;
import java.util.List;

public class Divida {

	private List<Conta> contas = new ArrayList<>();
	private Mes mes;

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Float calcularValorTotal() {
		Float valorTotal = 0.0f;

		for (Conta conta : contas) {
			valorTotal += conta.getValor();
		}

		return valorTotal;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public void addConta(Conta conta) {

		this.contas.add(conta);

	}

}
