public class Obstaculo extends Objeto {

	public Obstaculo(int vida, int pos_x, int pos_y) {
		super(vida, pos_x, pos_y);
	}
	public void revisarVida(){
		System.out.println("Jeje, sigo estorbando");
	}
	
}
