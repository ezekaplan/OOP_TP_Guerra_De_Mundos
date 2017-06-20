/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import model.planeta.TipoPlaneta;

/**
 *
 * @author nicolas
 */
public class VistaFormularioPrincipal extends JFrame{
    
    private JTextField jugador = null;
    private JTextField planeta = null;
    
    public VistaFormularioPrincipal(){
        //Defino caracteristicas de la ventana
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(640, 480);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(null);
        this.setResizable(false);
        
        JLabel cantJu = new JLabel("Cantidad de jugadores:");
        JLabel cantPl = new JLabel("Cantidad de planetas:");
        JButton jugar = new JButton("Jugar!");
        jugador = new JTextField();
        planeta = new JTextField();
        jugador.setText("0");
        planeta.setText("0");
        
        cantJu.setBounds(100, 100, 200, 50);
        cantPl.setBounds(300, 100, 200, 50);
        jugador.setBounds(100, 200, 200, 50);
        planeta.setBounds(300, 200, 200, 50);
        jugar.setBounds(300, 400, 100, 50);
        
        this.add(cantPl);
        this.add(cantJu);
        this.add(jugador);
        this.add(planeta);
        this.add(jugar);
        
        /*Falta el evento al hacer clic en jugar para que se cree el universo con la cantidad de planetas
        y jugadores especificados, el tipo de planeta puede setearse de manera random solo sabiendo la cantidad
        de planetas, o sea, hacer un while hasta crear la cantidad de planetas, y sacar un numero aleatorio, si
        el numero es menor que 1000 se crea un planeta chico, si esta entre 1000 y 2000 se crea uno mediano
        y si es mayor que 2000 se crea un planeta grande.*/
        
        //Creo las listas que necesita el universo.
        List<Planeta> planetas = new ArrayList<Planeta>();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        
        //Creo un jugador
        Jugador jugador1 = new Jugador();
        
        //Creo el tipo de planeta para poder crear un planeta.
        TipoPlaneta tplaneta = TipoPlaneta.GRANDE;
        
        //Creo el planeta y lo agrego al la lista de planetas.
        Planeta p = new Planeta(jugador1, tplaneta);
        planetas.add(p);
        
        jugadores.add(jugador1);//Agrego al jugador
        Universo universo = new Universo(planetas, jugadores);/*Creo el universo y le paso las listas con un jugador
                                                              y un planeta en cada lista.*/
        
        
    }
}
