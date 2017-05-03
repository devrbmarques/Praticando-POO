import java.util.List;

public class Mes {
   
    public Mes() {}

    private String nomeMes;    
    private List<Dividas> dividas;
    
	public String getNomeMes() {
		return nomeMes;
	}
	public void setNomeMes(String nomeMes) {
		this.nomeMes = nomeMes;
	}
	public List<Dividas> getDividas() {
		return dividas;
	}
	public void setDividas(List<Dividas> dividas) {
		this.dividas = dividas;
	}
    
}