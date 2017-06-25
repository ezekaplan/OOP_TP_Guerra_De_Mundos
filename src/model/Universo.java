package model;

import model.planeta.Planeta;
import java.util.List;

public class Universo {

    List<Planeta> planetas;
    List<Jugador> jugadores;

    public Universo(List<Planeta> planetas, List<Jugador> jugadores) {
        this.planetas = planetas;
        this.jugadores = jugadores;
    }

    public Universo(){

    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
