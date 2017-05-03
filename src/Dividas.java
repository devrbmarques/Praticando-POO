import java.util.List;

public class Dividas {

    public Dividas() {}
    
    private Mes mes;
    private List<Contas> contas;
    private Float valorTotal;
    
    
    
    public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public List<Contas> getContas() {
		return contas;
	}

	public void setContas(List<Contas> contas) {
		this.contas = contas;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Contas> listarContasMes() {
        return null;
    }
    
    public Float calcularTotal() {
        return null;
    }

}