package principal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import financeiro.Conta;
import financeiro.Divida;
import financeiro.Mes;
import pessoal.Usuario;

public class Main {
	
	private static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		String operacao;
		do {
			operacao = JOptionPane
					.showInputDialog("\t <<Controle de Financas>> \n "
							+ "1- Cadastrar Usuário \n "
							+ "2- Cadastrar Conta\n "
							+ "3- Exlcuir conta\n "
							+ "4- Obter total por mês\n "
							+ "s- Para sair " );

			if (operacao.charAt(0) == '1') {
				cadastrarUsuario();
			}

			if (operacao.charAt(0) == '2') {
				cadastrarConta();
			}

			if (operacao.charAt(0) == '3') {
				excluirConta();
			}
			
			if (operacao.chartAt(0) =='4') {
				obterTotalDivida();

		} while (operacao.charAt(0) != 's');
	}	
		private static void cadastrarUsuario() {

			Usuario usuario = new Usuario();

			usuario.setNome(JOptionPane.showInputDialog("Informe o nome do usuario: "));
			usuario.setCpf(JOptionPane.showInputDialog("Informe o cpf do usuario"));
			
			usuarios.add(usuario);
		}
		
		private static void cadastrarConta() {
			
			String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");
			
			Usuario usuarioEncontrado = null;
			
			for (Usuario usuario : usuarios) {

				if (usuario.getCpf().equals(cpf)) {
					usuarioEncontrado = usuario;
				}
			}
			if (usuarioEncontrado == null) {
				JOptionPane.showInputDialog("Usuario nao cadastrado");
			}
		}
		
		
		
		
		
		
		
		
}
	
	