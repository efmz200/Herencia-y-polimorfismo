import java.util.List;

import javax.naming.event.ObjectChangeListener;

public class Recolector extends Agente{

    public Recolector(int posicion_x, int posicion_y){
        super (posicion_x,posicion_y);
        
    }
    
    public void accion_especial(List<Objeto> amenazas,int num_amenaza){////funcion en la que se huye
        Objeto amenaza= amenazas.get(num_amenaza); 
        int x= get_pos_x();
        int y= get_pos_y();
        switch ((int) Math.random()*1){// decide si acercarse al aliado en x o en y
            case 0:// se acerca en x
                if(x<amenaza.get_pos_x()){
                    mover(4,amenazas);    
                }
                if(x>amenaza.get_pos_x()){
                    mover(3,amenazas);    
                }
            case 1:// se acerca en y
                if(y<amenaza.get_pos_x()){
                    mover(2,amenazas);    
                }
                if(y>amenaza.get_pos_x()){
                    mover(1,amenazas);    
                }                                
        }   
    }
    
}   
