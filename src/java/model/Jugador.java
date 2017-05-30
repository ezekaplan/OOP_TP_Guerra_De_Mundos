package java.model;

import java.controller.TurnoController;
import java.model.planeta.Planeta;
import java.observer.IObservador;
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
