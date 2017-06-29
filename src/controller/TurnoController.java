package controller;

import model.Jugador;

import java.util.LinkedList;

public class TurnoController {

    public static Jugador jugador;

    private static TurnoController instance;

    private TurnoController() {}

    public static TurnoController getInstance() {
        if (instance == null) {
            instance = new TurnoController();
        }

        return instance;
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static void setJugador(Jugador jugador) {
        TurnoController.jugador = jugador;
    }

    public void activeJugador(LinkedList<Jugador> jugadores) {
        this.jugador = jugadores.removeFirst();
        jugadores.add(this.jugador);
    }
}
