package java.controller;

import java.model.Jugador;

public class TurnoController {

    private static Jugador jugador;

    public static Jugador getJugador() {
        return jugador;
    }

    public static void setJugador(Jugador jugador) {
        TurnoController.jugador = jugador;
    }
}
