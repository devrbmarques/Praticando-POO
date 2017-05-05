package financeiro;
//Conta nada sabe de ninguém por isso nela há somente seus atributos
public class Conta {

	private Float valor;
	private int codigo;
	private String nome;

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}