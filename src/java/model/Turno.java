package java.model;

/**
 * Created by Federico on 21/5/2017.
 */
public class Turno {

    private static Jugador jugador;

    public static Jugador getJugador() {
        return jugador;
    }

    public static void setJugador(Jugador jugador) {
        Turno.jugador = jugador;
    }
}
