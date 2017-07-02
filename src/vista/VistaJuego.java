package vista;

import controller.TurnoController;
import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import observer.IObservador;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by nicolas on 24/06/2017.
 */
/*Esta vista es el formulario que aparece después de haber ingresado los nombres de los jugadores.
* Acá es donde se ve la lista de planetas y se empieza a jugar.*/
public class VistaJuego extends JFrame{

    JLabel  acciones = new JLabel("Acciones disponibles: ");
    JButton naves = new JButton();
    JButton torretas = new JButton();
    JButton produccion = new JButton();
    JButton colonizar = new JButton();
    JButton atacarNaves = new JButton();
    JButton atacarPlanetas = new JButton();
    private int jugadorActivo = 0;

    public int getJugadorActivo() {
        return jugadorActivo;
    }

    public VistaJuego() {
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        boolean primerTurno = true;
        this.setLayout(null);

        System.out.println(Universo.getInstance().getJugadores().get(0).getNombre());
        //Las etiquetas:
        //do {
            Jugador jugador = new Jugador("");
            if(primerTurno){
                jugador = Universo.getInstance().getJugadores().get(jugadorActivo);
                Universo.getInstance().setJugadorActivo(jugadorActivo);
                primerTurno = false;
            }else if((jugadorActivo + 1 ) == Universo.getInstance().getJugadores().size()){
                jugadorActivo = 0;
                Universo.getInstance().setJugadorActivo(jugadorActivo);
            }else{
                jugadorActivo += 1;
                jugador = Universo.getInstance().getJugadores().get(jugadorActivo);
                Universo.getInstance().setJugadorActivo(jugadorActivo);
            }
            JLabel jug = new JLabel("Turno del jugador: " + jugador.getNombre());
            JLabel pl = new JLabel("Cantidad de planetas: " + jugador.getCantidadPlanetas());
            jug.setBounds(10, 10, 250, 20);
            pl.setBounds(10, 40, 250, 20);
            this.add(jug);
            this.add(pl);

            this.setSize(640, 480);
            for (int i = 0; i < jugador.getCantidadPlanetas(); i++) {
                Planeta planeta = jugador.getPlanetas().get(i);
                JLabel planetaLabel = new JLabel("Planeta " + (i + 1) + " Tipo Planeta: "
                        + planeta.getTipoPlaneta().name() + " Poblacion: " + planeta.getPoblacion()
                        + " Cantidad de naves: " + planeta.getNaves().size() + " Cantidad de torretas: "
                        + planeta.getTorretas().size() + " Cap. Prod. " + planeta.getCapacidadDeProduccion());
                planetaLabel.setBounds(10, (70 + (i * 20)), 600, 20);
                this.add(planetaLabel);
                //Si crea la última label, crea los botones debajo:
                if ((i + 1) == jugador.getCantidadPlanetas()) {

                    acciones.setBounds(10, (100 + (i * 20)), 250, 20);

                    naves.setBounds(10, (120 + (i * 20)), 170, 30);
                    naves.setText("Producir naves");

                    torretas.setBounds(190, (120 + (i * 20)), 170, 30);
                    torretas.setText("Producir torretas");

                    produccion.setBounds(370, (120 + (i * 20)), 170, 30);
                    produccion.setText("Aumentar producción");

                    colonizar.setBounds(10, (160 + (i * 20)), 170, 30);
                    colonizar.setText("Colonizar");

                    atacarNaves.setBounds(190, (160 + (i * 20)), 170, 30);
                    atacarNaves.setText("Atacar naves");

                    atacarPlanetas.setBounds(370, (160 + (i * 20)), 170, 30);
                    atacarPlanetas.setText("Atacar planeta");
                    this.add(acciones);
                    this.add(naves);
                    this.add(torretas);
                    this.add(produccion);
                    this.add(colonizar);
                    this.add(atacarNaves);
                    this.add(atacarPlanetas);
                }
            }

            naves.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                }
            });

            torretas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                }
            });

            produccion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    VistaAccion accion = new VistaAccion( VistaJuego.this, 3);
                    accion.setVisible(true);

                    //VistaJuego.this.repaint();
                }
            });

            colonizar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                }
            });

            atacarNaves.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                }
            });

            atacarPlanetas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                }
            });
        /*//Los campos de texto:
        JTextField jugador = new JTextField();
        JTextField planeta = new JTextField();
        jugador.setText("0");
        planeta.setText("0");
        jugador.setBounds(210, 10, 50, 20);
        planeta.setBounds(210, 40, 50, 20);
        this.add(jugador);
        this.add(planeta);*/

            //El botón para seguir:
            JButton continuar = new JButton();
            continuar.setText("Pasar turno");
            continuar.setBounds(255, 420, 130, 20);
            this.add(continuar);
        //}while(Universo.getInstance().getJugadores().size() != 1);
    }
}
