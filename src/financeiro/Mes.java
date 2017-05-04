package financeiro;

import java.util.List;

public class Mes {

	private String nomeMes;
	private List<Divida> dividas;

	public String getNomeMes() {
		return nomeMes;
	}

	public void setNomeMes(String nomeMes) {
		this.nomeMes = nomeMes;
	}

	public List<Divida> getDividas() {
		return dividas;
	}

	public void setDividas(List<Divida> dividas) {
		this.dividas = dividas;
	}

}