package vista;

import controller.JuegoController;
import controller.TurnoController;
import model.Jugador;
import model.Universo;
import model.planeta.Planeta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nicolas on 24/06/2017.
 */
public class VistaInicio extends JFrame {

    private Universo model;
    private LinkedList<JTextField> jugadoresLista = new LinkedList<>();
    private int jugadores = 0, planetas = 0;

    public VistaInicio() {
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 150);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        //Las etiquetas:
        JLabel jug = new JLabel("Ingrese la cantidad de jugadores:");
        JLabel pl = new JLabel("Ingrese la cantidad de planetas:");
        jug.setBounds(10, 10, 250, 20);
        pl.setBounds(10, 40, 250, 20);
        this.add(jug);
        this.add(pl);

        //Los campos de texto:
        JTextField jugador = new JTextField();
        JTextField planeta = new JTextField();
        jugador.setText("0");
        planeta.setText("0");
        jugador.setBounds(210, 10, 50, 20);
        planeta.setBounds(210, 40, 50, 20);
        this.add(jugador);
        this.add(planeta);

        //El botón para seguir:
        JButton continuar = new JButton();
        continuar.setText("Siguiente");
        continuar.setBounds(110, 80, 100, 20);
        this.add(continuar);

        //Creo el botón comenzar que luego lo voy a usar.
        JButton comenzar = new JButton();
        comenzar.setText("Comenzar a jugar!");
        comenzar.setBounds(90, 340, 140, 20);

        //El evento del clic en el botón continuar:
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int aux, ypos = 40;
                jugadores = Integer.parseInt(jugador.getText());
                planetas = Integer.parseInt(planeta.getText());
                VistaInicio.this.setSize(320, 400);
                jugador.setVisible(false);
                planeta.setVisible(false);
                jug.setVisible(false);
                pl.setVisible(false);
                continuar.setVisible(false);
                //Creo la nueva etiqueta:
                JLabel ljug = new JLabel("Ingrese los nombres de los jugadores:");
                ljug.setBounds(10, 10, 250, 20);
                VistaInicio.this.add(ljug);
                //Agrego botón de Comenzar.
                VistaInicio.this.add(comenzar);
                //Creo los campos de texto según la cantidad de jugadores.
                for (aux = jugadores; aux > 0; aux--) {
                    JTextField jnuevo = new JTextField();
                    jnuevo.setBounds(10, ypos, 200, 20);
                    ypos = ypos + 30;
                    //VistaInicio.this.add(jnuevo);
                    jugadoresLista.add(jnuevo);
                }
                for (JTextField aJugadoresLista : jugadoresLista) {
                    VistaInicio.this.add(aJugadoresLista);
                }
            }
        });
        Comenzar comenzar1 = new Comenzar();
        comenzar1.setVistaInicio(this);
        comenzar.addActionListener(comenzar1);
    }

    class Comenzar implements ActionListener {

        private VistaInicio vistaInicio;

        @Override
        public void actionPerformed(ActionEvent evt) {
            //Como obtengo el texto de cada elemento de la lista? ya estan agregados, solo tengo que llamar
            //al metodo crear universo.
            //para saber si los nombres se crearon bien.
            LinkedList<Jugador> jugadores = new LinkedList<>();
            for (JTextField aJugadoresLista : jugadoresLista) {
                System.out.println(aJugadoresLista.getText());
                jugadores.add(new Jugador(aJugadoresLista.getText()));
            }
            JuegoController.getInstance().crearUniverso(jugadores, planetas);
            TurnoController.getInstance().activeJugador(jugadores);
            VistaJuego vistaJuego = new VistaJuego();
            vistaJuego.setVisible(true);
            vistaInicio.dispatchEvent(new WindowEvent(vistaInicio, WindowEvent.WINDOW_CLOSING));
        }

        public void setVistaInicio(VistaInicio vistaInicio) {
            this.vistaInicio = vistaInicio;
        }
    }
}
