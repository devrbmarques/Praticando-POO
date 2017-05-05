package principal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import financeiro.Conta;
import financeiro.Divida;
import financeiro.Mes;
import pessoal.Usuario;

public class Main {
	//criação do Array usuários. Usuários cadastrados são guardados nele.
	private static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		//Criação do menu
		String operacao;
		do {
			operacao = JOptionPane.showInputDialog(
							"\t <<Controle de Financas>> \n "
							+ "1- Cadastrar Usuário \n "
							+ "2- Cadastrar Conta\n "
							+ "3- Exlcuir conta\n "
							+ "4- Obter total por mês\n "
							+ "'s'- Para sair " );

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
			//instanciando um objeto do tipo Usuario
			Usuario usuario = new Usuario();
			//utiliza-se dos métodos modificadores para guardar o nome e o cpf do usário e 
			//guarda essas informações
			usuario.setNome(JOptionPane.showInputDialog("Informe o nome do usuario"));
			usuario.setCpf(JOptionPane.showInputDialog("Informe o cpf do usuario"));
			//insere o objeto instanciado no Array criado no início do código
			usuarios.add(usuario);
		}
		
		private static void cadastrarConta() {
			//Declara uma variável do tipo String 'cpf' e guarda o CPF informado logo abaixo
			String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");
			//Declara uma variável do tipo Usuario 'usuarioEncontrado' e inicia-se com valor null = "vazio do JAVA"
			Usuario usuarioEncontrado = null;
			//faz uma varredura no array usuarios, verificando um usuario do tipo Usuario por vez
			for (Usuario usuario : usuarios) {
				//compara se o cpf inserido é igual ao atributo cpf do usuário que já se tem cadastrado
				if (usuario.getCpf().equals(cpf)) {
					usuarioEncontrado = usuario;
				}
			}
			//caso cpf não seja de nenhum usuário já cadastrado, entra no 'if' logo abaixo
			if (usuarioEncontrado == null) {
				JOptionPane.showInputDialog("Usuario nao cadastrado");
			//usando a função 'return', ele sai do método e não executa mais nada abaixo desse if
				return;
			}
		}
		
		
		
		
		
		
		
		
}
	
	