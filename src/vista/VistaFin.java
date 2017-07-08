package vista;

import model.Universo;

import javax.swing.*;

/**
 * Created by Nicolás on 08/07/2017.
 */
public class VistaFin extends JFrame{

    public VistaFin(){
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        JLabel ganaste = new JLabel(Universo.getInstance().getJugadores().get(0).getNombre() + " GANASTE EL JUEGO!!");
        ganaste.setBounds(30, 30, 300, 30);
        this.add(ganaste);
    }

}
