import java.util.List;

public class Usuario {

    public Usuario() {}

    private String nome;
    private List<Dividas> dividas;
    private String cpf;
    
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Dividas> getDividas() {
		return dividas;
	}

	public void setDividas(List<Dividas> dividas) {
		this.dividas = dividas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void cadastrarConta() {
        return null;
    }

    public void deletarConta(int codigo) {
        return null;
    }

}