package vista;

import controller.TurnoController;
import model.Jugador;
import model.planeta.Planeta;

import javax.swing.*;

/**
 * Created by nicolas on 24/06/2017.
 */
/*Esta vista es el formulario que aparece después de haber ingresado los nombres de los jugadores.
* Acá es donde se ve la lista de planetas y se empieza a jugar.*/
public class VistaJuego extends JFrame {

    public VistaJuego() {
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        //Las etiquetas:
        Jugador jugador = TurnoController.jugador;
        JLabel jug = new JLabel("Turno del jugador: " + jugador.getNombre());
        JLabel pl = new JLabel("cantidad de planetas:" + jugador.getCantidadPlanetas());
        jug.setBounds(10, 10, 250, 20);
        pl.setBounds(10, 40, 250, 20);
        this.add(jug);
        this.add(pl);

        for (int i = 0; i < jugador.getCantidadPlanetas(); i++) {
            Planeta planeta = jugador.getPlanetas().get(i);
            JLabel planetaLabel = new JLabel("Planeta " + i + 1 + " Tipo Planeta: "
                    + planeta.getTipoPlaneta().name() + " Poblacion: " + planeta.getPoblacion());
            planetaLabel.setBounds(10, 70 + i * 10, 250, 20);
            this.add(planetaLabel);
        }

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
        continuar.setText("Siguiente");
        continuar.setBounds(110, 80, 100, 20);
        this.add(continuar);
    }

}
