package java.model.naves;


import java.model.batalla.Poder;

public class NaveDestructora extends Nave {

    private static final Integer costo = 1;

    public NaveDestructora() {
        super(costo);
    }

    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderDestructor(poder.getPoderDestructor() + this.getPoder());
    }
}
