package vista;

import controller.TurnoController;
import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import observer.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 24/06/2017.
 */
/*Esta vista es el formulario que aparece después de haber ingresado los nombres de los jugadores.
* Acá es donde se ve la lista de planetas y se empieza a jugar.*/
public class VistaJuego extends JFrame implements IObservador{

    JLabel  acciones = new JLabel("Acciones disponibles: ");
    JButton naves = new JButton();
    JButton torretas = new JButton();
    JButton produccion = new JButton();
    JButton colonizar = new JButton();
    JButton atacarNaves = new JButton();
    JButton atacarPlanetas = new JButton();
    boolean primerTurno = true;
    private int jugadorActivo = Universo.getInstance().getJugadorActivo();
    private List<JLabel> etiquetas = new ArrayList<JLabel>();

    public int getJugadorActivo() {
        return jugadorActivo;
    }

    public VistaJuego() {
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(600, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);

        System.out.println(Universo.getInstance().getJugadores().get(0).getNombre());

        for(Jugador i : Universo.getInstance().getJugadores()){
            if(i.getPlanetas().size() <= 0){
                Universo.getInstance().getJugadores().remove(i);
            }
        }

        if(Universo.getInstance().getJugadores().size() == 1){
            VistaFin fin = new VistaFin(Universo.getInstance().getJugadores().get(0).getNombre());
            fin.setVisible(true);
        }

        crearEtiquetas();

            acciones.setBounds(10, 280, 250, 20);

            naves.setBounds(10, 320, 170, 30);
            naves.setText("Producir naves");

            torretas.setBounds(190, 320, 170, 30);
            torretas.setText("Producir torretas");

            produccion.setBounds(370, 320, 170, 30);
            produccion.setText("Aumentar producción");

            colonizar.setBounds(10, 370, 170, 30);
            colonizar.setText("Colonizar");

            atacarNaves.setBounds(190, 370, 170, 30);
            atacarNaves.setText("Atacar naves");

            atacarPlanetas.setBounds(370, 370, 170, 30);
            atacarPlanetas.setText("Atacar planeta");
            this.add(acciones);
            this.add(naves);
            this.add(torretas);
            this.add(produccion);
            this.add(colonizar);
            this.add(atacarNaves);
            this.add(atacarPlanetas);
            naves.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    VistaAccion producirNaves = new VistaAccion(VistaJuego.this, 1);
                    producirNaves.setVisible(true);
                }
            });

            torretas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    VistaAccion producirTorretas = new VistaAccion(VistaJuego.this, 2);
                    producirTorretas.setVisible(true);
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
                    VistaAccion accion = new VistaAccion( VistaJuego.this, 4);
                    accion.setVisible(true);
                }
            });

            atacarNaves.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    VistaAccion accion = new VistaAccion( VistaJuego.this, 5);
                    accion.setVisible(true);
                }
            });

            atacarPlanetas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    VistaAccion accion = new VistaAccion( VistaJuego.this, 6);
                    accion.setVisible(true);
                }
            });

            /*JButton refrescar = new JButton();
            refrescar.setText("Actualizar");
            refrescar.setBounds(10, 420, 130, 20);
            this.add(refrescar);*/

            /*refrescar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    VistaJuego.this.repaint();

                }
            });*/
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
            /*JButton continuar = new JButton();
            continuar.setText("Pasar turno");
            continuar.setBounds(255, 420, 130, 20);
            this.add(continuar);*/
        //}while(Universo.getInstance().getJugadores().size() != 1);
    }

    @Override
    public void actualizar(Object arg) {

    }

    public void crearEtiquetas(){
        //Las etiquetas:
        //do {
        Jugador jugador = new Jugador("");
        jugador = Universo.getInstance().getJugadores().get(jugadorActivo);
        /*if(primerTurno){
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
        }*/
        JLabel jug = new JLabel("Turno del jugador: " + jugador.getNombre());
        JLabel pl = new JLabel("Cantidad de planetas: " + jugador.getCantidadPlanetas() + "     Recursos: " +
                                jugador.getRecursos());
        jug.setBounds(10, 10, 500, 20);
        pl.setBounds(10, 40, 500, 20);
        this.add(jug);
        this.add(pl);

        this.setSize(900, 480);
        for (int i = 0; i < jugador.getCantidadPlanetas(); i++) {
            Planeta planeta = jugador.getPlanetas().get(i);
            JLabel planetaLabel = new JLabel("Planeta " + (i + 1) + " Tipo Planeta: "
                    + planeta.getTipoPlaneta().name() + " Poblacion: " + planeta.getPoblacion()
                    + " Cantidad de naves: " + planeta.getNaves().size() + "(batalla) " + planeta.getNavesColonizadoras().size()
                    + "(colonizadoras) " + planeta.getFlotas().size() + "(destructoras) " + " Cantidad de torretas: "
                    + planeta.getTorretas().size() + " Cap. Prod. " + planeta.getCapacidadDeProduccion());
            planetaLabel.setBounds(10, (70 + (i * 20)), 900, 20);
            etiquetas.add(planetaLabel);
            this.add(planetaLabel);
        }
    }
}
