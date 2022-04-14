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
            amemanaza.set_vida(amemanaza.get_vida()+1);
            objamenazas.set(num_amenaza,amemanaza);
        }
        switch ((int) Math.random()*1){// decide si acercarse a la amenaza en x o en y
            case 0:// se acerca en x
                if(x<amenaza_x){
                    if(get_pos_x()==0){
                        break;
                    }
                    set_pos_x(get_pos_x()+1);   
                }
                if(x>amenaza_x+1){
                    if(get_pos_x()==49){
                        break;
                    }
                    set_pos_x(get_pos_x()-1);                       
                }
            case 1:// se acerca en y
                if(y<amenaza_y){
                    if(get_pos_y()==0){
                        break;
                    }
                    set_pos_y(get_pos_y()-1);    
                }
                if(y>amenaza_y+1){
                    if(get_pos_y()==49){
                        break;
                    }
                    set_pos_y(get_pos_y()+1);    
                }                                
        }
    }
    
}
