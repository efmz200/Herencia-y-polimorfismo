//import java.security.PublicKey;
import java.util.List;

public class Defensor extends Agente{
    public Defensor(int posicion_x, int posicion_y){
        super(posicion_x,posicion_y);

    }
  
    public void accion_especial(List<Objeto> objamenazas,int num_amenaza){//funcion en la que se ataca
        int x=get_pos_x();
        int y=get_pos_y();
        Objeto amemanaza = objamenazas.get(num_amenaza);
        int amenaza_x=amemanaza.get_pos_x();
        int amenaza_y=amemanaza.get_pos_y();
        if(Math.abs(x-amenaza_x)==1 && Math.abs(y-amenaza_y)==1){
            amemanaza.set_vida(amemanaza.get_vida()-1);
            objamenazas.set(num_amenaza,amemanaza);
        }
        switch ((int) Math.random()*1){// decide si acercarse al aliado en x o en y
            case 0:// se acerca en x
                if(x<amenaza_x){
                    mover(3,objamenazas);    
                }
                if(x>amenaza_x){
                    mover(4,objamenazas);    
                }
            case 1:// se acerca en y
                if(y<amenaza_y){
                    mover(1,objamenazas);    
                }
                if(y>amenaza_y){
                    mover(2,objamenazas);    
                }                                
        }
    }
    
}
