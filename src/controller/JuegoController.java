package controller;

import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import model.planeta.TipoPlaneta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class JuegoController {

    private LinkedList<Jugador> jugadores;
    List<Planeta> planetas = new ArrayList<>();

    private static JuegoController instance;

    private JuegoController() {
    }

    public static JuegoController getInstance() {
        if (instance == null) {
            instance = new JuegoController();
        }
        return instance;
    }


    public void crearUniverso(LinkedList<Jugador> jugadoresList, int cantPlanetas) {
        /*Le paso la lista de jugadores y la cantidad de planetas, después el resto lo hace este método.
        * Crea la lista de planetas, la de jugadores, y las setea en el modelo.*/
        this.jugadores = jugadoresList;

        //Imaginemos que la cant de planetas es múltiplo de los jugadores.
        int planetasPorJugador = cantPlanetas / jugadoresList.size();
        int aux = 0;
        int indiceLista = 0;

        //La asignacion de los planetas es random.
        //Creo los tipoPlaneta:
        Random aleatorio = new Random();

        for (aux = 0; aux < planetasPorJugador; aux++) {
            Jugador jugador = jugadores.get(indiceLista);
            Planeta planeta;
            aux = aleatorio.nextInt(3001);//Genera un random entre 0 y 3000.
            if (aux < 1001) {//Si esta entre 0 y 1000 es un planeta chico.
                TipoPlaneta chico = TipoPlaneta.CHICO;//Cree la enum.
                //Creo el tipoDePlaneta:
                planeta = new Planeta(jugador, chico);
            } else if (aux > 1000 && aux < 2001) {//Aux esta entre 1000 y 2000. Planeta mediano.
                TipoPlaneta mediano = TipoPlaneta.MEDIANO;//Cree la enum.
                //Creo el tipoDePlaneta:
                planeta = new Planeta(jugador, mediano);
            } else {//Aux es mayor que 2000. Planeta grande.
                TipoPlaneta grande = TipoPlaneta.GRANDE;//Cree la enum.
                //Creo el tipoDePlaneta:
                planeta = new Planeta(jugador, grande);
            }
            jugador.addPlaneta(planeta);
            planetas.add(planeta);
        }

        //Ya tengo las dos listas completas ahora creo el universo:
        Universo.getInstance().setJugadores(jugadores);
        Universo.getInstance().setPlanetas(planetas);
    }
}
