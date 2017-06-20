package model;

import controller.TurnoController;
import model.planeta.Planeta;
import observer.IObservador;
import java.util.List;

public class Jugador implements IObservador<Planeta> {
    List<Planeta> planetas;
    private String nombre;

    @Override
    public void actualizar(Planeta planeta) {
        if (TurnoController.getJugador().equals(this)) {
            planetas.add(planeta);
        } else {
            planetas.remove(planeta);
        }
    }
}
