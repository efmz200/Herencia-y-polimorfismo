
import java.util.List;
//import java.util.Random;

public abstract class Agente {
    private int pos_y;
    private int pos_x;
    private int pos_y_objetivo;
    private int pos_x_objetivo;
    private int estado;//0 si esta neutro, 1 si esta atacando, -1 si está huyendo
    private boolean lleva_carga;    
    
    public Agente(int y,int x){
        pos_y=y;
        pos_x=x;
        estado=0;
        lleva_carga=false;   
    }
    public abstract void recolectar();//se debe cambiar para que reciva una lista de objetos
    public abstract boolean buscar_aliado();//
    public abstract boolean buscar_amenaza();
    public abstract void marcar_objetivo();
    public abstract void buscar_recurso();    
    public abstract void buscar_amenaza(List<Objeto> objetos);    


    public void buscar_aliado(List<Agente> aliados){   
        for(int i=0;i<aliados.size();i++){
            Agente agt_aux= aliados.get(i);
            if(Math.abs(agt_aux.pos_y-pos_y)==1 && Math.abs(agt_aux.pos_x-pos_x)==1){//Revisa que el aliado este en un radio de 1

            }
        } 
    }
    public boolean colision(Agente agt){
        return true;
    }
    public void mover(int direccion){//se debe cambiar para que reciva una lista de objetos para saber si hay obstaculos
        if (direccion<1){
            direccion = (int) (Math.random()*4+1);
        }
        switch(direccion){
            case 1:
                pos_y++;
                break;
            case 2:
                pos_y--;
                break;
            case 3:
                pos_x++;
                break;
            case 4:
                pos_x--;
                break;
        }
    } 

    //getters and setters
    public void set_pos_y(int y){
        pos_y=y;
    }
    public void set_pos_x(int y){
        pos_y=y;
    }
    public void set_pos_y_obj(int y){
        pos_y_objetivo=y;
    }
    public void set_pos_x_obj(int x){
        pos_x_objetivo=x;
    }
    public void set_estado(int estado){
        this.estado=estado;
    }
    public void set_carga(boolean carga){
        lleva_carga=carga;
    }     

    public int get_pos_y(){
        return pos_y;
    }
    public int get_pos_x(){
        return pos_y;
    }
    public int get_pos_y_obj(){
        return pos_y_objetivo;
    }
    public int get_pos_x_obj(){
        return pos_x_objetivo;
    }
    public int get_estado(){
        return estado;
    }
    public boolean get_carga(){
        return lleva_carga;
    }
    
    

    
}
