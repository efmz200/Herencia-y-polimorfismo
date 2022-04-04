import java.security.PublicKey;
import java.util.List;

public class Defensor extends Agente{
    public Defensor(int posicion_x, int posicion_y){
        super(posicion_x,posicion_y);

    }

    @Override
    public void recolectar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean buscar_aliado() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void marcar_objetivo() {
        
    }

    @Override
    public void buscar_recurso() {
       
    }

    @Override
    public boolean buscar_amenaza(List<Objeto> objetos) {
        
        for(int i=0;i<objetos.size();i++){
            Objeto obj_aux=objetos.get(i);
            if(obj_aux.get_vida()<1){
                int dist_x=get_pos_x()-obj_aux.get_pos_x();
                int dist_y=get_pos_y()-obj_aux.get_pos_y();
                int dist_objt = (int) Math.sqrt( Math.pow(dist_x,2)+Math.pow(dist_y,2));                
                if(dist_objt<4){
                    atacar(objetos,i);
                    return false;
                }        
            }
        } 
        return true; 
    }
    
    public void atacar(List<Objeto> objetos,int num_amenaza){
        
    }
    
}
