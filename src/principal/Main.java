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
							+ "2- Cadastrar Conta   \n "
							+ "3- Exlcuir conta     \n "
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
			}*/
			
			if (operacao.charAt(0) =='4') {
				obterTotalDivida();
			}

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
													 + "<agosto>	\n" 
													 + "<setembro>  \n" 
													 + "<outubro>	\n" 
													 + "<novembro>  \n" 
													 + "<dezembro> \n\n" 
													 + "Informe o mes da divida"));
			//variável que será usada para se ter um controle se o mês fornecido é válido ou inválido
			int ocorrencia = 0;
			//'iteracao' recebe o conteúdo de cada posição do array_mes
			for (String iteracao : nome_mes) {
			//verifica se o nome do mês que o usuário forneceu é um mês válido. Variavel ocorrencia é incrementada
				if(mes.getNomeMes().equals(iteracao)) ocorrencia += 1;
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
			//menu para criacao de conta
					operacao = JOptionPane.showInputDialog("\t <<Divida>> \n 1- Cadastrar Conta \n s- Finalizar cadastro de Divida\n ");

					if (operacao.charAt(0) == '1') {
			/*if '1', é chamado o método cadastrarConta e passa como parâmetro o objeto divida.
			lembrando, nas linhas anteriores, setamos um determinado mês para divida.*/
						cadastrarConta(divida);
					}
					if (operacao.charAt(0) == 's') {
			//por ser do tipo 'Usuario', variável 'ususarioEncontrado' chama o método addDivida() e passa como parâmetro a dívida recebida
						usuarioEncontrado.addDivida(divida);
					}
				} while (operacao.charAt(0) != 's');
			}
		}
		
		
		
		private static void cadastrarConta(Divida divida) {
			//Divida conhece sobre conta. Instancia-se um objeto 'conta' do tipo Conta
			Conta conta = new Conta();
			//Array composto pelas contas validas
			String[] nome_conta = {"agua","luz","supermercado","gasolina","lazer"};
			//usuário fornece o codigo da conta que deseja cadastrar
			conta.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("1- agua 			\n" 
																	   + "2- luz			\n" 
																	   + "3- supermercado	\n" 
																	   + "4- gasolina		\n" 
																	   + "5- lazer			\n\n" 
																	   + "Informe o codigo da conta")));
			//caso o valor do código fornecido pelo usuário ultrapassar os limites dos códigos já definidos
			if ((conta.getCodigo() > 5) || (conta.getCodigo() < 1)) {
				JOptionPane.showMessageDialog(null, "Codigo invalido, voce sera redirecionado.");
				return;
			}
			//usuário fornece o nome da conta
			conta.setNome(JOptionPane.showInputDialog("Informe o nome da conta"));
			int contador = 0;
			//'iteracao' recebe o conteúdo do array, um a um. 
			for (String iteracao: nome_conta) {
			/*já entra no for incrementando a variavel contador assim, caso a conta informada for agua, 
			o codigo fornecido pelo usuário será o correspondente a conta*/
				contador += 1;
			//quando o nome da conta for igual ao do array, o loop é encerrado pelo comando 'break'
				if (conta.getNome().equals(iteracao)) break;
			} 
			//verifica se a variavel contador corresponde ao código que o usuário inseriu. Assim definimos a integridaede das informações
			if (contador == conta.getCodigo()) {
			//caso corresponda, é direcionado ao último passo do cadastramento da conta que é inserir seu valor
				conta.setValor(Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da conta")));
			}else {
			//caso o valor de contador for diferente do código que o usuário inseriu quando lhe foi solicitado que inserisse o código da conta.
				JOptionPane.showMessageDialog(null, "Codigo e nome da conta nao correspondem. Voce sera redirecionado");
				return;
			}
			//ao término do cadastramento, a conta é cadastrada no array que há na classe Divida.
			divida.addConta(conta);

		}
		
		
		
		private static void obterTotalDivida() {
		
			String cpf = JOptionPane.showInputDialog("Informe o cpf do usuario");
			Usuario usuarioEncontrado = null;

			for (Usuario usuario : usuarios) {
				if (usuario.getCpf().equals(cpf)) {
					usuarioEncontrado = usuario;
				}
			}
			if (usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Usuario nao cadastrado, voce sera redirecionado");
				return;
			}else {
				Mes mes = new Mes();
				//solicitado ao usuario o mês que ele deseja saber o total de suas dívidas
				mes.setNomeMes(JOptionPane.showInputDialog("Informe o mes"));
				Divida divida = usuarioEncontrado.buscarDivida(mes);

				JOptionPane.showMessageDialog(null,
						"Valor total divida de " + mes.getNomeMes() + " é " + divida.calcularValorTotal());
			}
		}
		
		
}
	
	