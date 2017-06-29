package principal;

import javax.swing.*;

import controller.JuegoController;
import model.Universo;
import vista.VistaInicio;

/**
 * Created by nicolas on 24/06/2017.
 */
public class Programa {
    public static void main(String [] args){

        //Creo la vista:
        JFrame inicio = new VistaInicio();
        inicio.setVisible(true);

        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame inicio = new VistaInicio();
                inicio.setVisible(true);
            }
        });*/
    }
}
