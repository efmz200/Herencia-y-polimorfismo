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
			if (agt_aux.get_se_movio() == true) { // Revisando si el agente se movio
				continue;
			}
			else {
				agt_aux.mover (0); //agregar lista de objetos
			}

		}

	}

	public void revisar_objetos () {//llama a la funcion de revisar vida de los objetos para reposicionarlos
		for (int i=0; i<objetos.size (); i++) {
				Objeto obj_aux = objetos.get(i);
				obj_aux.revisarVida();
			}
		}
	
	public void generar_objetos() {
		for (int i=0; i<5; i++) { 
			objetos.add(new Amenaza(-11, (int) Math.random() *50, (int) Math.random() *50)); 
			objetos.add(new Recurso(11, (int) Math.random() *50, (int) Math.random() *50));
			objetos.add(new Obstaculo(0, (int) Math.random() *50, (int) Math.random() *50));
		}
	}

	public void generar_agentes () { 
		for (int i=0; i<49; i++) { 
			//agentes.add(new Amenaza((int) Math.random() *50, (int) Math.random() *50));

		}
	}
	//public void actualizar_interfaz () {}

	public void reiniciar_variable_movimiento() {
		for (int i= 0; i<agentes.size (); i++) {
			Agente agt_aux = agentes.get(i);
			agt_aux.set_se_movio (false);
			agentes.set (i, agt_aux);
		}

	}

	//public void simular () {

	//}
	
}




