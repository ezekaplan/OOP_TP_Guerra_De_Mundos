package java.model.naves;

import java.model.ElementoDeBatalla;
import java.model.ElementoDeJuego;
import java.model.batalla.Poder;

public abstract class Nave extends ElementoDeBatalla {

    private static final Integer fuerza = 100;

    public Nave(int costo) {
        super(costo);
    }

    public abstract void sumarPoder(Poder poder);

    public Integer getPoder() {
        return fuerza * 1;
    }

}
