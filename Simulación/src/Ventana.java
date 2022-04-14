import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*; 

public class Ventana implements ActionListener{
    ArrayList<ArrayList<Integer>> mat;
    JFrame ventana;
    JPanel panel;
    Simulacion simulacion;
    JButton simulButton;

    public Ventana(){
        //inicia la simulación
        simulacion=new Simulacion();
        simulacion.iniciar();

        //inicia la ventana
        ventana = new JFrame("Abejitas uwu");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        ventana.setLayout(new BorderLayout());

        //inicia el panel donde se van a cargar las etiquetas
        panel= new JPanel();
        panel.setLayout(new GridLayout(50,51));
        rellenar_labels();//se llama a la función que rellena los labels

        simulButton = new JButton("simular"); 
        simulButton.addActionListener(this); 
        panel.add(simulButton); 
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }

    public void rellenar_labels(){
        ArrayList<ArrayList<Integer>> mat=simulacion.obtener_matriz();
        for(int i=0;i<49;i++){
            for(int j=0;j<49;j++){
                int tipo_casilla=mat.get(i).get(j);
                JLabel label = new JLabel();
                label.setOpaque(true);
                switch((int) tipo_casilla){
                    case -1:
                        label.setBackground(Color.orange);//casa
                        panel.add(label);
                        continue;
                    case 1:
                        label.setBackground(Color.yellow);//agente
                        panel.add(label);
                        continue;
                    case 2:
                        label.setBackground(Color.blue);//obstaculo
                        panel.add(label);
                        continue;
                    case 3: 
                        label.setBackground(Color.green);//recurso
                        panel.add(label);
                        continue;
                    case 4:
                        label.setBackground(Color.red);//amenazas
                        panel.add(label);
                        continue;
                    case 0:
                        label.setBackground(Color.black);//demas casillas
                        panel.add(label); 
                        continue;
                }
                            
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        panel= new JPanel();
        panel.setLayout(new GridLayout(50,51));
        simulacion.simular();
        rellenar_labels(); 
        panel.add(simulButton); 
        ventana.add(panel);        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    

}