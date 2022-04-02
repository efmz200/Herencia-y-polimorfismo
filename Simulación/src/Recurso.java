public class Recurso extends Objeto {

	public Recurso(int vida, int pos_x, int pos_y) {
		super(vida, pos_x, pos_y);
	}

	public void revisarVida(){
		if (this.get_vida()<1){
			set_pos_x((int) Math.random() *49);
			set_pos_y((int) Math.random() *49);
			set_vida(10);
		}
	}



	
}
