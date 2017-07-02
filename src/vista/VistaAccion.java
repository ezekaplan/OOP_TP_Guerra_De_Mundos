package vista;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;

import model.Universo;
import vista.*;

/**
 * Created by Nicolás on 02/07/2017.
 */
public class VistaAccion extends JFrame{

    VistaAccion(VistaJuego ventana, int n){
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        switch (n){
            //Para producir naves:
            case 1:

                ;
            //Para producir torretas:
            case 2:
                ;
            //Para aumentar capacidad de produccion:
            case 3:
                JLabel texto = new JLabel("¿Cuál planeta quiere mejorar?:");
                texto.setBounds(10, 20, 250, 20);
                this.add(texto);
                JTextField numero = new JTextField();
                numero.setBounds(10, 50, 150, 20);
                this.add(numero);
                JLabel informacion = new JLabel("");
                informacion.setBounds(10, 80, 300, 20);
                this.add(informacion);
                numero.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        if(numero.getText() != null){
                            int jugadorAct = Universo.getInstance().getJugadorActivo();
                            if(Integer.parseInt(numero.getText()) > 0){
                                if(Integer.parseInt(numero.getText())-1 < Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().size())
                                    informacion.setText("Planeta: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getTipoPlaneta().name() +
                                            " Cap. Prod. actual: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                                //System.out.println("Texto cambiado");
                            }
                        }else{
                            informacion.setText("Numero de planeta inválido.");
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        informacion.setText("");
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        if(numero.getText() != null){
                            int jugadorAct = Universo.getInstance().getJugadorActivo();
                            if(Integer.parseInt(numero.getText()) > 0){
                                if(Integer.parseInt(numero.getText())-1 < Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().size())
                                    informacion.setText("Planeta: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getTipoPlaneta().name() +
                                            " Cap. Prod. actual: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                                //System.out.println("Texto cambiado");
                            }
                        }else{
                            informacion.setText("Numero de planeta inválido.");
                        }
                    }

                });
                JButton aceptar = new JButton();
                aceptar.setText("Aceptar");
                aceptar.setBounds(110, 240, 100, 20);
                this.add(aceptar);

                aceptar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        int jugadorActivo = Universo.getInstance().getJugadorActivo();
                        Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(numero.getText())-1).aumentarCapacidadDeProduccion();
                        System.out.println("Cap. prod.: "+Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                        VistaAccion.this.dispose();
                    }
                });
                /*numero.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    }
                });*/
                ;
            //Para colonizar:
            case 4:
                ;
            //Para atacar naves:
            case 5:
                ;
            //Para atacar planetas:
            case 6:
                ;
            default:
                System.out.println("Hecho");
        }


    }
}
