package java.model.naves;

import java.model.ElementoDeBatalla;
import java.model.Poder;

public abstract class Nave extends ElementoDeBatalla{

    private static final Integer fuerza = 100;

    public abstract void sumarPoder(Poder poder);

    public Integer getPoder() {
        return fuerza * nivel;
    }

}
