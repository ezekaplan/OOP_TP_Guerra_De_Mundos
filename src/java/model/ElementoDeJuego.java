package java.model;

import java.observer.Observado;

public abstract class ElementoDeJuego extends Observado {

    public void avanzarTurno() {
        this.actualizarObservadores(null);
    }
}
