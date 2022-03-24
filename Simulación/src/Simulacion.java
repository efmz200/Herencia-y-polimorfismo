import java.util.ArrayList;
import java.util.List;

public class Simulacion {
	
	private List<Agente> agentes;
	private List<Objeto> objetos;
	private int posicion_casa;

	public Simulacion() {
		agentes = new ArrayList<Agente>();
		objetos = new ArrayList<Objeto>();
		posicion_casa = (int) (Math.random() *4);
	}

	public void movimiento () {
		for (int i=0; i<agentes.size (); i++) {
			Agente agt_aux = agentes.get(i);
			if (Math.abs ())

		}

	}
	

}



