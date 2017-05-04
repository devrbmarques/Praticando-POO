package principal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import financeiro.Conta;
import financeiro.Divida;
import financeiro.Mes;
import pessoal.Usuario;

public class Menu {

	private static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {

		String operacao;
		do {
			operacao = JOptionPane
					.showInputDialog("\t <<Controle de Financas>> \n 1-Cadastrar Usuário \n 2-Cadastrar Divida\n 3- Obter total por mês ");

			if (operacao.charAt(0) == '1') {
				cadastrarUsuario();
			}

			if (operacao.charAt(0) == '2') {
				cadastrarDivida();
			}

			if (operacao.charAt(0) == '3') {
				obterTotalDivida();
			}

		} while (operacao.charAt(0) != 'f');

	}

	private static void obterTotalDivida() {

		String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");

		Usuario usuarioEncontrado = null;

		for (Usuario usuario : usuarios) {

			if (usuario.getCpf().equals(cpf)) {
				usuarioEncontrado = usuario;
			}
		}

		Mes mes = new Mes();

		mes.setNomeMes(JOptionPane.showInputDialog("Informe o mes"));

		Divida divida = usuarioEncontrado.buscarDivida(mes);

		JOptionPane.showMessageDialog(null,
				"Valor total divida de " + mes.getNomeMes() + " é " + divida.calcularValorTotal());

	}

	private static void cadastrarDivida() {

		String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");

		Usuario usuarioEncontrado = null;

		for (Usuario usuario : usuarios) {

			if (usuario.getCpf().equals(cpf)) {
				usuarioEncontrado = usuario;
			}
		}
		
		

		Divida divida = new Divida();

		Mes mes = new Mes();

		mes.setNomeMes(JOptionPane.showInputDialog("Informe o mes da divida"));
		
		divida.setMes(mes);

		String operacao = null;

		do {
			operacao = JOptionPane
					.showInputDialog("\t <<Divida>> \n 1-Cadastrar Conta \n f-Finalizar cadastro de Divida\n ");

			if (operacao.charAt(0) == '1') {
				cadastrarConta(divida);
			}

			if (operacao.charAt(0) == 'f') {

				usuarioEncontrado.addDivida(divida);
			}

		} while (operacao.charAt(0) != 'f');

	}

	private static void cadastrarConta(Divida divida) {
		Conta conta = new Conta();

		conta.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo da conta")));
		conta.setNome(JOptionPane.showInputDialog("Informe o nome da conta"));
		conta.setValor(Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da conta")));

		divida.addConta(conta);

	}

	private static void cadastrarUsuario() {

		Usuario usuario = new Usuario();

		usuario.setNome(JOptionPane.showInputDialog("Informe o nome do usuario"));
		usuario.setCpf(JOptionPane.showInputDialog("Informe o cpf do usuario"));
		
		usuarios.add(usuario);

	}

}
