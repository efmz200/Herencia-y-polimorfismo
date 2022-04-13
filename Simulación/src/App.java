import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hi");
        Simulacion simulacion= new Simulacion();
        simulacion.iniciar();
        simulacion.obtener_matriz();        
        simulacion.simular();
        //simulacion.obtener_matriz();
        ArrayList<ArrayList<Integer>> matriz=simulacion.obtener_matriz();
        for (int i=0; i<matriz.size();i++){
            System.out.println(matriz.get(i));
        }
    }
}
