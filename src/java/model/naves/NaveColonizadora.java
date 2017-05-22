package java.model.naves;

import java.model.Poder;

/**
 * Esta nave debe ser mandada para colonizar los planetas que ya no tienen torretas.
 */
public class NaveColonizadora extends Nave {

    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderColonizador(poder.getPoderColonizador() + this.getPoder());
    }
}
