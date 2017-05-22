package java.model.naves;


import java.model.Flota;
import java.model.Poder;

public class NaveDestructor extends Nave {

    @Override
    public void sumarPoder(Poder poder) {
        poder.setPoderDestructor(poder.getPoderDestructor() + this.getPoder());
    }
}
