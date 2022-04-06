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
		for (int i=0; i<agentes.size (); i++) {  //estamos recorriendo la lista de Agentes
			Agente agt_aux = agentes.get(i); //Estamos seleccionando un agente
			agt_aux.mover(0,objetos); //agregar lista de objetos
		}

	}
	
	public void generar_objetos() {
		for (int i=0; i<5; i++) { 
			objetos.add(new Amenaza(-11, (int) Math.random() *46 +2, (int) Math.random() *46 +2)); //45 para que no se salga de los limites 
			objetos.add(new Recurso(11, (int) Math.random() *46  +2, (int) Math.random() *46 +2));
			objetos.add(new Obstaculo(0, (int) Math.random() *46 +2, (int) Math.random() *46 +2));
		}
	}

	public void generar_agentes () { 
		for (int i=0; i<24; i++) { 
			agentes.add(new Defensor ((int) Math.random() *48 +1, (int) Math.random() *48 +1));
			agentes.add(new Recolector ((int) Math.random() *48 +1, (int) Math.random() *48 +1));
		}
	}


	public void actualizar_interfaz () {



	}

	public void simular () {
		generar_objetos();
		while (true) {
			for (int i= 0; i<agentes.size(); i++) {
				agentes.get (i).actuar();
			}
			for (int i=0; i<objetos.size (); i++) {
				objetos.get (i).revisarVida();
			}
			actualizar_interfaz();
		}

		}
	
	public void actualizar_agentes () {




}




