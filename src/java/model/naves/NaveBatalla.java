package java.model.naves;

import java.model.Flota;
import java.model.Poder;

/**
 * Ataca a naves enemigas.
 */
public class NaveBatalla extends Nave {
    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderBatalla(poder.getPoderBatalla() + this.getPoder());
    }
}
