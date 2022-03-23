import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Agente {
    private int pos_y;
    private int pos_x;
    private int pos_y_objetivo;
    private int pos_x_objetivo;
    private int estado;//0 si esta neutro, 1 si esta atacando, -1 si está huyendo
    private boolean lleva_carga;
    private boolean se_movio;
    private List<Agente> seguidores;
    
    public Agente(int y,int x){
        pos_y=y;
        pos_x=x;
        estado=0;
        lleva_carga=false;
        se_movio=false;
        seguidores= new ArrayList<Agente>();
                 
    }
    public abstract void recolectar();//se debe cambiar para que reciva una lista de objetos
    public abstract boolean buscar_aliado();
    public abstract boolean buscar_amenaza();
    public abstract void marcar_objetivo();
    public abstract void buscar_recurso();

    public void buscar_aliado(Agente[] aliados){   
        for(int i=0;i<aliados.length;i++){
            Agente agt_aux= aliados[i];
            if(Math.abs(agt_aux.pos_y-pos_y)==1 && Math.abs(agt_aux.pos_x-pos_x)==1){//Revisa que el aliado este en un radio de 1

            }
        }    

    }
    public boolean colision(Agente agt){//


        return true;
    }
    public void mover(int direccion){//se debe cambiar para que reciva una lista de objetos para saber si hay obstaculos
        if (direccion<1){
            direccion = (int) (Math.random()*4+1);
        }
        switch(direccion){
            case 1:
                pos_y++;
                se_movio=true;
                break;
            case 2:
                pos_y--;
                se_movio=true;
                break;
            case 3:
                pos_x++;
                se_movio=true;
                break;
            case 4:
                pos_x--;
                se_movio=true;
                break;
        }
    } 

    
}
