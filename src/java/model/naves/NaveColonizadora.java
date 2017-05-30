package java.model.naves;

import java.model.batalla.Poder;

/**
 * Esta nave debe ser mandada para colonizar los planetas que ya no tienen torretas.
 */
public class NaveColonizadora extends Nave {

    private static final Integer costo = 2;

    public NaveColonizadora() {
        super(costo);
    }

    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderColonizador(poder.getPoderColonizador() + this.getPoder());
    }
}
