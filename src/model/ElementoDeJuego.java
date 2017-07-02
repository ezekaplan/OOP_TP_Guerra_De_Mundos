package model;

import observer.Observado;

public abstract class ElementoDeJuego extends Observado {

    public void avanzarTurno() {

        this.actualizarObservadores(null);
    }
}
