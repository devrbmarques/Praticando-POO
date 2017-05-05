package financeiro;

import java.util.List;

public class Mes {

	private String nomeMes;
	//Mes sabe informar qual divida o compõe. Criamos um array dividas para determinar a associação. 
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