public class Recurso extends Objeto {

	public Recurso(int vida, int pos_x, int pos_y) {
		super(vida, pos_x, pos_y);
	}

	public void revisarVida(){
		System.out.print("Aun tengo: "+ (get_vida()-1)+" recursos \n");
		if (this.get_vida()==1){
			System.out.println("Se acabó el recurso");
			set_pos_x((int) (Math.random() *46) +2);
			set_pos_y((int) (Math.random() *46) +2);
			System.out.println("El recurso se movio a: "+get_pos_x()+", "+get_pos_y());
			set_vida(11);
		}
	}
	
}
