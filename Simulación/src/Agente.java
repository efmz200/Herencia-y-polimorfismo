
import java.util.List;
//import java.util.Random;

public abstract class Agente {
    private int pos_y;
    private int pos_x;
    private int pos_y_objetivo;
    private int pos_x_objetivo;
    private int estado;//0 sin carga, 1 con carga
       
    
    public Agente(int x,int y){
        pos_y=y;
        pos_x=x;
        estado=0;   
    }     
    public abstract void accion_especial(List<Objeto> objetos,int num_amenaza); //escapar o atacar segun el agente   


    
    public void actuar(List<Objeto> obstaculos,List<Agente> aliados){;
        while(true){
            if(estado==1){//si tiene carga intenta volver a casa
                if(volver_casa(obstaculos,aliados.get(0))){
                    break;
                }    
            }
            if(buscar_amenaza(obstaculos)){//revisa si hay amenazas
                break;   
            } 
            if(estado==0){
                if(buscar_recurso(obstaculos)){ //busca recursos
                    break;    
                }
            }            
            if(buscar_aliado(aliados,obstaculos)){//busca aliados
                break;
            }
            else{
                mover(0,obstaculos);
                break;
            }
        }      
    }

    //funcion que hace que el agente regrese a casa al estar cargado
    public boolean volver_casa(List<Objeto> obstaculos,Agente casa){
        System.out.println("Estoy a: "+Math.abs(pos_x-casa.get_pos_x())+"en x de casa y a: "+(Math.abs(pos_y-casa.get_pos_y()))+"en y");
        if ((Math.abs(pos_x-casa.get_pos_x())<2) && (Math.abs(pos_y-casa.get_pos_y())<2) ){//esta en rango de la casa
            System.out.println("deje un recurso en casa en:"+pos_x+", "+ pos_y);
            estado=0; 
            return false;   
        }
        else{
            if(pos_x<casa.get_pos_x()){
                mover(3,obstaculos); 
                return true;                   
            }
            else if(pos_x>casa.get_pos_x()){
                mover(4,obstaculos);   
                return true;                 
            }
        
            else if(pos_y<casa.get_pos_y()){
                mover(1,obstaculos);
                return true; 
                   
            }
            else if(pos_y>casa.get_pos_y()){
                mover(2,obstaculos); 
                return true;                   
            } 
            return false;
        }
        

    }
    public boolean buscar_recurso(List<Objeto> objetos){
        for(int i=0;i<objetos.size();i++){
            Objeto obj_aux=objetos.get(i);
            if(obj_aux.get_vida()>1){
                int dist_x=get_pos_x()-obj_aux.get_pos_x();
                int dist_y=get_pos_y()-obj_aux.get_pos_y();
                int dist_objt = (int) Math.sqrt( Math.pow(dist_x,2)+Math.pow(dist_y,2));                
                if(dist_objt<4){
                    if(dist_objt < 2){
                        if(obj_aux.get_vida()>1){
                            obj_aux.set_vida(obj_aux.get_vida()-1);// recoge un recurso
                            objetos.set(i,obj_aux);//actualiza el recurso en la lista de objetos 
                            estado=1;  
                        }                        
                        mover(0, objetos);
                        return true;
                    }
                    else{
                        switch((int) Math.random()*2){ //decide si moverse al recurso o de manera random
                            case 0://se mueve al aliado
                                switch ((int) Math.random()*2){// decide si acercarse al recurso en x o en y
                                    case 0:// se acerca en x
                                        if(pos_x<obj_aux.get_pos_x()){
                                            mover(3,objetos);    
                                        }
                                        if(pos_x>obj_aux.get_pos_x()){
                                            mover(4,objetos);    
                                        }
                                    case 1:// se acerca en y
                                        if(pos_y<obj_aux.get_pos_x()){
                                            mover(1,objetos);    
                                        }
                                        if(pos_y>obj_aux.get_pos_x()){
                                            mover(2,objetos);    
                                        }                                
                                }
                            case 1://se mueve random
                                mover(0,objetos);
                        }
                        return true;
                    }
                    
                }        
            }
        } 
        return false;
    }
    //funcion que busca si hay una amenaza cerca 
    public boolean buscar_amenaza(List<Objeto> objetos){
        for(int i=0;i<objetos.size();i++){
            Objeto obj_aux=objetos.get(i);
            if(obj_aux.get_vida()<-1){
                int dist_x=get_pos_x()-obj_aux.get_pos_x();
                int dist_y=get_pos_y()-obj_aux.get_pos_y();
                int dist_objt = (int) Math.sqrt( Math.pow(dist_x,2)+Math.pow(dist_y,2));                
                if(dist_objt<3){
                    accion_especial(objetos,i);
                    return true;
                }        
            }
        } 
        return false; 
    }

    public boolean buscar_aliado(List<Agente> aliados,List<Objeto> obstaculos){   
        for(int i=1;i<aliados.size();i++){
            Agente agt_aux= aliados.get(i);
            if(Math.abs(agt_aux.pos_y-pos_y)==3 && Math.abs(agt_aux.pos_x-pos_x)==3){//Revisa que el aliado este en un radio de 1
                switch((int) (Math.random()*2)){ //decide si movere al aliado o de manera random
                    case 0://se mueve al aliado
                        switch ((int) (Math.random()*2)){// decide si acercarse al aliado en x o en y
                            case 0:// se acerca en x
                                if(pos_x<agt_aux.get_pos_x()){
                                    mover(3,obstaculos);    
                                }
                                if(pos_x>agt_aux.get_pos_x()){
                                    mover(4,obstaculos);    
                                }
                            case 1:// se acerca en y
                                if(pos_y<agt_aux.get_pos_y()){
                                    mover(1,obstaculos);    
                                }
                                if(pos_y>agt_aux.get_pos_y()){
                                    mover(2,obstaculos);    
                                }                                
                        }
                    case 1://se mueve random
                        mover(0,obstaculos);
                }
                return true;   
            }
        } 
        return false;//no tenia ningun aliado cerca por lo que no se movi?? 
    }
    
    public void mover(int direccion,List<Objeto> obstaculos){//verificar la colision
        if (direccion==0){
            direccion = (int) (Math.random()*4)+1;
        }
        switch(direccion){
            case 1://abajo
                if (pos_y+1>49 ){
                    break;
                }   
                if(colision(this, obstaculos, direccion)){
                    switch ((int) (Math.random()*2)){// decide si acercarse al recurso en x o en y
                        case 0:
                            if(pos_x>0){
                                pos_x--;
                                break;
                            }                            
                        case 1:
                            if(pos_x<49){
                                pos_x++;
                                break;
                            }
                    }  
                }                 
                pos_y++;
                break;
            case 2://arriba
                if (pos_y-1<0){
                    break;
                } 
                if(colision(this, obstaculos, direccion)){
                    switch ((int) (Math.random()*2)){// decide si acercarse al recurso en x o en y
                        case 0:
                            if(pos_x>0){
                                pos_x--;
                                break;
                            }                            
                        case 1:
                            if(pos_x<49){
                                pos_x++;
                                break;
                            }
                                
                    }
                }
                pos_y--;
                break;
            case 3://derecha
                if (pos_x+1>49){
                    break;
                }   
                if(colision(this, obstaculos, direccion)){
                    switch ((int) (Math.random()*2)){
                        case 0:
                            if(pos_y>0){
                                pos_y--;
                                break;
                            }                            
                        case 1:
                            if(pos_y<49){
                                pos_y++;
                                break;  
                            }                    
                    }
                }
                pos_x++;
                break;
            case 4://izquierda
                if (pos_x-1<0 ){
                    break;
                }
                if(colision(this, obstaculos, direccion)){
                    switch ((int) (Math.random()*2)){
                        case 0:
                            if(pos_y>0){
                                pos_y--;
                                break;
                            }                            
                        case 1:
                            if(pos_y<49){
                                pos_y++;
                                break;
                            }
                    }
                }
                pos_x--;
                break;
        }
    
    } 

    public boolean colision(Agente agt,List<Objeto> obstaculos, int direccion){
        switch(direccion){
            case 1:
                for(int i=0; i < obstaculos.size();i++){//colision en y por arriba
                    if(((agt.get_pos_y()+1)==(obstaculos.get(i).get_pos_y()-1)) && (agt.get_pos_x()==obstaculos.get(i).get_pos_x() || agt.get_pos_x()==(obstaculos.get(i).get_pos_x()+1) )){
                        return true;
                    }
                }
            case 2:
                for(int i=0; i < obstaculos.size();i++){//colision en y por abajo
                    if((agt.get_pos_y()-1==obstaculos.get(i).get_pos_y()) && (agt.get_pos_x()==obstaculos.get(i).get_pos_x() || agt.get_pos_x()==(obstaculos.get(i).get_pos_x()+1) )){
                        return true;
                    }
                }
            case 3:
                for(int i=0; i < obstaculos.size();i++){//colision en x por la izq
                    if(((agt.get_pos_x()+1)==obstaculos.get(i).get_pos_x()) &&(agt.get_pos_y()==obstaculos.get(i).get_pos_y() || agt.get_pos_y()==(obstaculos.get(i).get_pos_y()-1 ))){
                        return true;
                    }
                }
            case 4:
                for(int i=0; i < obstaculos.size();i++){//posicion en x por al der
                    if(((agt.get_pos_x()-1)==(obstaculos.get(i).get_pos_x()+1)) && (agt.get_pos_y()==obstaculos.get(i).get_pos_y() || (agt.get_pos_y()==(obstaculos.get(i).get_pos_y()-1)) )){
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
    public void set_pos_x(int x){
        pos_x=x;
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

    public int get_pos_y(){
        return pos_y;
    }
    public int get_pos_x(){
        return pos_x;
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
}
