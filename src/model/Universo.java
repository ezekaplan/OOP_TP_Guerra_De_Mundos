package model;

import model.planeta.Planeta;
import java.util.List;

public class Universo {

    List<Planeta> planetas;
    List<Jugador> jugadores;
    private int jugadorActivo;

    public void setJugadorActivo(int jugadorActivo) {
        this.jugadorActivo = jugadorActivo;
    }

    public int getJugadorActivo() {
        return jugadorActivo;
    }

    private static Universo instance;

    private Universo() {}

    public static Universo getInstance() {
        if (instance == null) {
            instance = new Universo();
        }
        return instance;
    }



    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
