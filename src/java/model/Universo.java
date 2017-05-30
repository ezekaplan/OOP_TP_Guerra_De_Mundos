package java.model;

import java.model.planeta.Planeta;
import java.util.List;

public class Universo {

    List<Planeta> planetas;
    List<Jugador> jugadores;

    public Universo(List<Planeta> planetas, List<Jugador> jugadores) {
        this.planetas = planetas;
        this.jugadores = jugadores;
    }
}
