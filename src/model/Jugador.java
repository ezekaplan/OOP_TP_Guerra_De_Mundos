package model;

import controller.TurnoController;
import model.planeta.Planeta;
import observer.IObservador;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements IObservador<Planeta> {
    private List<Planeta> planetas = new ArrayList<>();
    private String nombre;

    public Jugador(String n){
        this.nombre = n;
    }
    @Override
    public void actualizar(Planeta planeta) {
        if (TurnoController.getJugador().equals(this)) {
            planetas.add(planeta);
        } else {
            planetas.remove(planeta);
        }
    }

    public void addPlaneta(Planeta planeta) {
        planetas.add(planeta);
    }

    public int getCantidadPlanetas(){
        return planetas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }
}
