/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.*;
import model.planeta.*;
import model.naves.*;
import model.batalla.*;
import vista.VistaFormularioPrincipal;

/**
 *
 * @author nicolas
 */
public class Programa {
    
    public static void main(String [] args){
        //Eran listas para crear el universo pero las movi a la clase VistaFormularioPrincipal.
        List<Planeta> planetas = new ArrayList<Planeta>();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        
//        Jugador jugador1 = new Jugador();
//        TipoPlaneta tplaneta = TipoPlaneta.GRANDE;
//        
//        Planeta p = new Planeta(jugador1, tplaneta);
//        planetas.add(p);
//        
//        jugadores.add(jugador1);
//        Universo universo = new Universo(planetas, jugadores);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                JFrame f = new VistaFormularioPrincipal();
                f.setVisible(true);
            }
        });
        
    }
}
