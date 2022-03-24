public abstract class Objeto  {

	private int vida;
	private int pos_x;
	private int pos_y;


	public Objeto (int vida, int pos_x, int pos_y) {

		this.vida = vida;
		this.pos_x = pos_x;
		this.pos_y = pos_y;

	}

//getters and setters
public void set_vida (int vida) {
	this.vida = vida;
}

public void set_pos_x (int pos_x) {
	this.pos_x = pos_x;
}

public void set_pos_y (int pos_y){
	this.pos_y = pos_y;
}

public int get_vida () {
	return vida;
	
}
public int get_pos_x () {
	return pos_x;
}
public int get_pos_y () {
	return pos_y;
}

}
