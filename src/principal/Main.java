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
							+ "s- Para sair " );

			if (operacao.charAt(0) == '1') {
				cadastrarUsuario();
			}

			if (operacao.charAt(0) == '2') {
				cadastrarDivida();
			}

			/*if (operacao.charAt(0) == '3') {
				excluirConta();
			}
			
			if (operacao.chartAt(0) =='4') {
				obterTotalDivida();*/

		} while (operacao.charAt(0) != 's');
	}	
		
		
		
		private static void cadastrarUsuario() {
			//instanciando um objeto do tipo Usuario
			Usuario usuario = new Usuario();
			/*utiliza-se dos métodos modificadores para guardar o nome e o cpf do usário e 
			guarda essas informações*/
			usuario.setNome(JOptionPane.showInputDialog("Informe o nome do usuario"));
			usuario.setCpf(JOptionPane.showInputDialog("Informe o cpf do usuario"));
			//insere o objeto instanciado no Array criado no início do código
			usuarios.add(usuario);
		}
		
		
		
		private static void cadastrarDivida() {
			//Declara uma variável do tipo String 'cpf' e guarda o CPF informado logo abaixo
			String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");
			//Declara uma variável do tipo Usuario, 'usuarioEncontrado', e inicia-se com valor null = "vazio no JAVA"
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
				JOptionPane.showMessageDialog(null,"Usuario nao cadastrado");
			//usando a função 'return', ele sai do método e não executa mais nada abaixo desse if
				return;
			}
			/*caso o cpf inserindo esteja ligado a determinado usuário já cadastrado, segue as instruções abaixo
			instancia um objeto, 'divida', do tipo divida*/
			Divida divida = new Divida();
			//instancia um objeto, 'mes', do tipo Mes
			Mes mes = new Mes();
			//array contendo o nome dos meses para comparação futura
			String[] nome_mes = {"janeiro","fevereiro","marco","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};
			//guarda o mes da divida usando o método setNomeMes() no objeto criado 'mes'
			mes.setNomeMes(JOptionPane.showInputDialog("<janeiro>   \n"
													 + "<fevereiro> \n" 
													 + "<marco>     \n" 
													 + "<abril>	    \n" 
													 + "<maio>	    \n" 
													 + "<junho>	    \n" 
													 + "<julho>	    \n" 
													 + "<jgosto>	\n" 
													 + "<setembro>  \n" 
													 + "<outubro>	\n" 
													 + "<novembro>  \n" 
													 + "<dezembro> \n\n" 
													 + "Informe o mes da divida"));
			//variável que será usada para ocorrência de o nome digitado pelo usuário não corresponda a mês algum
			int ocorrencia = 0;
			for (String iteracao : nome_mes) {
				if(mes.getNomeMes() == iteracao) {
					JOptionPane.showMessageDialog(null, "Pelo menos uma vez");
					ocorrencia += 1;
				}
			}
			//caso usuario tenha digitado um mês invalido
			if (ocorrencia == 0) {
				JOptionPane.showMessageDialog(null, "Nome do mes invalido!");
			//usando a função 'return', ele sai do método e não executa mais nada abaixo desse if
				return;
			}else {
			//usando o método setMes(), guarda-se o mês referente àquela dívida que foi inserida
				divida.setMes(mes);
				String operacao = null;
				do {
					operacao = JOptionPane.showInputDialog("\t <<Divida>> \n 1- Cadastrar Conta \n f- Finalizar cadastro de Divida\n ");

					if (operacao.charAt(0) == '1') {
			/*if '1', chama-se o método cadastrarConta e passa como parâmetro o objeto divida.
			lembrando, nas linhas anteriores, setamos um determinado mês para divida.*/
						cadastrarConta(divida);
					}
					if (operacao.charAt(0) == 'f') {
			//por ser do tipo 'Usuario', variável 'ususarioEncontrado' chama o método addDivida() e passa como parâmetro a dívida recebida
						usuarioEncontrado.addDivida(divida);
					}
				} while (operacao.charAt(0) != 'f');
			}
		}
		
		
		
		private static void cadastrarConta(Divida divida) {
			Conta conta = new Conta();

			conta.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo da conta")));
			conta.setNome(JOptionPane.showInputDialog("Informe o nome da conta"));
			conta.setValor(Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da conta")));

			divida.addConta(conta);

		}		
		
		
		
}
	
	