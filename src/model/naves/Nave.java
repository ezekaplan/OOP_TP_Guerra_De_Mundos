package model.naves;

import model.ElementoDeBatalla;
import model.batalla.Poder;

public abstract class Nave extends ElementoDeBatalla {

    protected static final Integer fuerza = 100;

    public Nave(int costo) {

        super(costo);
    }

    public abstract void sumarPoder(Poder poder);

    public Integer getPoder() {

        return fuerza;
    }

}
