import java.util.ArrayList;
import java.util.List;

public class Simulacion {
	
	private List<Agente> agentes;
	private List<Objeto> objetos;
	private int posicion_casa;

	public Simulacion() {
		agentes = new ArrayList<Agente>();
		objetos = new ArrayList<Objeto>();
		posicion_casa = (int) (Math.random() *3);
	}
	public void iniciar(){
		posicionar_casa();
		generar_objetos();
		generar_agentes();
	}
	public void posicionar_casa(){
		switch(posicion_casa){
			case 0://casa esquina sup izq
				agentes.add(new Recolector (1,1));
			case 1://casa esquina sup der
				agentes.add(new Recolector (49,1));
			case 2://casa esquina inf izq
				agentes.add(new Recolector (1,49));
			case 3://casa esquina inf der
				agentes.add(new Recolector (49,49));
		}	
		
	}
	public void movimiento () {
		for (int i=1; i<agentes.size (); i++) {  //estamos recorriendo la lista de Agentes
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
		agentes.add(new Recolector ((int) Math.random() *48 +1, (int) Math.random() *48 +1));
		for (int i=0; i<24; i++) { 
			agentes.add(new Defensor ((int) Math.random() *48 +1, (int) Math.random() *48 +1));
			agentes.add(new Recolector ((int) Math.random() *48 +1, (int) Math.random() *48 +1));
		}
	}


	public void actualizar_interfaz () {

	}

	public void simular () {
		generar_objetos();
		generar_agentes();
		while (true) {
			for (int i = 1; i<agentes.size(); i++) {
				agentes.get (i).actuar(objetos,agentes);
			}
			for (int i=0; i<objetos.size (); i++) {
				objetos.get (i).revisarVida();
			}
			actualizar_interfaz();
		}

		}

}




