package java.model;

import java.util.List;

public class Jugador {
    List<Planeta> planetas;
    private String nombre;

    public void update(Planeta planeta) {
        if (Turno.getJugador().equals(this)) {
            planetas.add(planeta);
        } else {
            planetas.remove(planeta);
        }
    }
}
