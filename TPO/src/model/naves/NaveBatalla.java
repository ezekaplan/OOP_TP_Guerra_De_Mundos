package model.naves;

import model.batalla.Poder;

/**
 * Ataca a naves enemigas.
 */
public class NaveBatalla extends Nave {

    private static final Integer costo = 3;

    public NaveBatalla() {
        super(costo);
    }

    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderBatalla(poder.getPoderBatalla() + this.getPoder());
    }
}
