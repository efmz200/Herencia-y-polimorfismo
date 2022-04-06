
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
    public abstract void marcar_objetivo();
    public abstract void buscar_recurso(); 
    public abstract void accion_especial(List<Objeto> objetos,int num_amenaza);     


    
    
    
    public boolean buscar_recurso(List<Objeto> objetos){
        for(int i=0;i<objetos.size();i++){
            Objeto obj_aux=objetos.get(i);
            if(obj_aux.get_vida()<1){
                int dist_x=get_pos_x()-obj_aux.get_pos_x();
                int dist_y=get_pos_y()-obj_aux.get_pos_y();
                int dist_objt = (int) Math.sqrt( Math.pow(dist_x,2)+Math.pow(dist_y,2));                
                if(dist_objt<4){
                    accion_especial(objetos,i);
                    return false;
                }        
            }
        } 
        return false;
    }
    //funcion que busca si hay una amenaza cerca 
    public boolean buscar_amenaza(List<Objeto> objetos){
        for(int i=0;i<objetos.size();i++){
            Objeto obj_aux=objetos.get(i);
            if(obj_aux.get_vida()<1){
                int dist_x=get_pos_x()-obj_aux.get_pos_x();
                int dist_y=get_pos_y()-obj_aux.get_pos_y();
                int dist_objt = (int) Math.sqrt( Math.pow(dist_x,2)+Math.pow(dist_y,2));                
                if(dist_objt<4){
                    accion_especial(objetos,i);
                    return false;
                }        
            }
        } 
        return true; 
    }

    public boolean buscar_aliado(List<Agente> aliados,List<Objeto> obstaculos){   
        for(int i=0;i<aliados.size();i++){
            Agente agt_aux= aliados.get(i);
            if(Math.abs(agt_aux.pos_y-pos_y)==3 && Math.abs(agt_aux.pos_x-pos_x)==3){//Revisa que el aliado este en un radio de 1
                switch((int) Math.random()*1){ //decide si movere al aliado o de manera random
                    case 0://se mueve al aliado
                        switch ((int) Math.random()*1){// decide si acercarse al aliado en x o en y
                            case 0:// se acerca en x
                                if(pos_x<agt_aux.get_pos_x()){
                                    mover(3,obstaculos);    
                                }
                                if(pos_x>agt_aux.get_pos_x()){
                                    mover(4,obstaculos);    
                                }
                            case 1:// se acerca en y
                                if(pos_y<agt_aux.get_pos_x()){
                                    mover(1,obstaculos);    
                                }
                                if(pos_y>agt_aux.get_pos_x()){
                                    mover(2,obstaculos);    
                                }                                
                        }
                    case 1://se mueve random
                        mover(0,obstaculos);
                }
                return true;   
            }
        } 
        return false;//no tenia ningun aleado cerca por lo que no se mivió 
    }
    
    public void mover(int direccion,List<Objeto> obstaculos){
        if (direccion<1){
            direccion = (int) (Math.random()*4+1);
        }
        switch(direccion){
            case 1:
                if (pos_y+1>50){
                    break;
                }                    
                pos_y++;
                break;
            case 2:
                if (pos_y-1<0){
                    break;
                } 
                pos_y--;
                break;
            case 3:
                if (pos_x+1>50){
                    break;
                }   
                pos_x++;
                break;
            case 4:
                if (pos_x-1<0){
                    break;
                } 
                pos_x--;
                break;
        }
    } 

    public boolean colision(Agente agt,List<Objeto> obstaculos, int direccion){
        switch(direccion){
            case 1:
                for(int i=0; i < obstaculos.size();i++){
                    if(agt.get_pos_y()+1==obstaculos.get(i).get_pos_y()){//colision en y por arriba
                        return true;
                    }
                }
            case 2:
            for(int i=0; i < obstaculos.size();i++){
                if(agt.get_pos_y()-1==obstaculos.get(i).get_pos_y()+1){//colision en y por abajo
                    return true;
                }
            }
            case 3:
                for(int i=0; i < obstaculos.size();i++){//colision en x por la izq
                    if(agt.get_pos_y()+1==obstaculos.get(i).get_pos_y()){
                        return true;
                    }
                }
            case 4:
            for(int i=0; i < obstaculos.size();i++){//posicion en x por al der
                if(agt.get_pos_x()-1==obstaculos.get(i).get_pos_y()){
                    return true;
                }
            }
        }
        return false;
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
