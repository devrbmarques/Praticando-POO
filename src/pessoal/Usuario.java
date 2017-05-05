package pessoal;

import java.util.ArrayList;
import java.util.List;

import financeiro.Divida;
import financeiro.Mes;

public class Usuario {

	private String nome;
	//Cria-se um Array dividas do tipo Dividas porque Usuario sabe quais são suas dívidas
	//Assim prendemos a composição das classes Usuário e Divida
	private List<Divida> dividas = new ArrayList<>();
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Divida> getDividas() {
		return dividas;
	}
	
	public void setDividas(List<Divida> dividas) {
		this.dividas = dividas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void addDivida(Divida divida) {
		this.dividas.add(divida);
	}
	
	public Divida buscarDivida(Mes mes) {
		
		for (Divida divida : dividas) {
			
			if (divida.getMes().getNomeMes().equals(mes.getNomeMes())) {
				return divida;
			}
		}
		
		return null;
	}

}
