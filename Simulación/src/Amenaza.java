public class Amenaza extends Objeto {

	public Amenaza(int vida, int pos_x, int pos_y) {
		
		super(vida, pos_x, pos_y);
	}
	public void revisarVida(){
		System.out.println("Me quedan: "+(get_vida()-1)+ " puntos de vida");
		if (this.get_vida()==-1){
			System.out.println("Se eliminó una amenaza");
			set_pos_x((int) (Math.random() *46) +2);
			set_pos_y((int) (Math.random() *46) +2);
			System.out.println("La amenaza se movio a: "+get_pos_x()+", "+get_pos_y());
			set_vida(-11);
		}
	}
	
}
