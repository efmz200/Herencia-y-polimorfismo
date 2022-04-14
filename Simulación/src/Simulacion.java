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
			objetos.add(new Amenaza(-11, (int) (Math.random() *46) +2, (int) (Math.random() *46) +2)); //45 para que no se salga de los limites 
			objetos.add(new Recurso(11, (int) (Math.random() *46)  +2, (int) (Math.random() *46) +2));
			objetos.add(new Obstaculo(0, (int) (Math.random() *46) +2, (int) (Math.random() *46) +2));
		}
	}

	public void generar_agentes () { 
		
		for (int i=0; i<24; i++) { 
			int posX = (int) (Math.random() *48);
			int posY = (int) (Math.random() *48);
			agentes.add(new Defensor (posX,posY));
		}
		for (int i=0; i<24; i++) { 
			int posX = (int) (Math.random()*48);
			int posY = (int) (Math.random()*48);			
			agentes.add(new Recolector (posX,posY));
		}
	}

	public ArrayList<ArrayList<Integer>> Crear_matriz(){
		ArrayList<ArrayList<Integer>> columna;
		columna= new ArrayList<ArrayList<Integer>>();
		//Se crea la matriz
		for(int i=0;i<50;i++){
			List<Integer> fila;
			fila= new ArrayList<Integer>();
			for(int j=0; j<50;j++){				
				fila.add(0); 
			}
			columna.add((ArrayList<Integer>) fila);
			
		}
		return columna;

	}

	public ArrayList<ArrayList<Integer>> obtener_matriz(){
		ArrayList<ArrayList<Integer>> mat=Crear_matriz();//genera una matriz vacía para poner los agentes
		//donde se ubica la casa se pone un -1
		//si hay un agente se pone un 1
		//si hay un obstaculo se pone un 2
		//si hay un recurso se pone un 3
		//si hay una amenaza se pone un 4
		for (int i=0; i<agentes.size();i++){
			Agente agt_aux= agentes.get(i);
			int col=agt_aux.get_pos_x();
			int fila=agt_aux.get_pos_y();
			if(i==0){
				mat.get(fila).set(col,-1);
				mat.get(fila-1).set(col,-1);
				mat.get(fila-1).set(col-1,-1);
				mat.get(fila).set(col-1,-1);
			}
			else{
				mat.get(fila).set(col,1);
			}	
			
		}
		
		for (int i=1; i<objetos.size();i++){
			Objeto obj_aux= objetos.get(i);
			int fila = obj_aux.get_pos_y();
			int col= obj_aux.get_pos_x();
			if(obj_aux.get_vida()==0){
				mat.get(fila).set(col,2);
				mat.get(fila+1).set(col,2);
				mat.get(fila+1).set(col+1,2);
				mat.get(fila).set(col+1,2);
			}	
			if(obj_aux.get_vida()>0){
				mat.get(fila).set(col,3);
				mat.get(fila+1).set(col,3);
				mat.get(fila+1).set(col+1,3);
				mat.get(fila).set(col+1,3);
			}
			
			if(obj_aux.get_vida()<0){
				mat.get(fila).set(col,4);
				mat.get(fila+1).set(col,4);
				mat.get(fila+1).set(col+1,4);
				mat.get(fila).set(col+1,4);
			}
		}
				
		return mat;
	}

	public void simular () {
		for (int i = 1; i<agentes.size(); i++) {
				agentes.get (i).actuar(objetos,agentes);
			}
		for (int i=0; i<objetos.size (); i++) {
				objetos.get (i).revisarVida();
			}			
		}

}




