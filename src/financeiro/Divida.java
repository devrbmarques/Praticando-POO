package financeiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Divida {
	//Amarra-se a composição criando um array chamado 'contas' do tipo Contas
	//Dívida tem conhecimento de quais contas a compõe
	private List<Conta> contas = new ArrayList<>();
	//Divida pode pertencer a somente um mês por isso nessa associação 
	//não cria-se um array do tipo mês mas somente um variável 'mes' do tipo Mes
	private Mes mes;
	//private int i=0;
	//private String allNomes[] = new String[contas.size()];
	
	public String imprimirContas(){
		boolean contasExistem = false;
		StringBuilder builder = new StringBuilder();
		for(Conta it : contas){
			contasExistem = true;
			builder.append("["+it.getCodigo()+"]");
			builder.append(".\t"+it.getNome());
			builder.append(" R$"+it.getValor());
			builder.append("\n");
			builder.append("\n");
		}
		if(!contasExistem){
			return ("Não há contas");
		}
		return builder.toString();
	}
	
	public void deletarDivida(int codigoConta) {
		for (int i = 0; i < contas.size() ; i++) {
			if (contas.get(i).getCodigo() == codigoConta) {
				contas.remove(contas.get(i));
				JOptionPane.showMessageDialog(null, "Conta excluída com sucesso. ");
			}
		}
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Float calcularValorTotal() {
		Float valorTotal = 0.0f;
		//Faz uma varredura no array contas criado acima e verifica, conta por conta
		//Por meio da função getValor, é inserido o valor da conta, do determinado usuário, na função abaixo
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
	
	public int tamanhoConta() {
		return contas.size();
	}
	
	
	
	
	
}