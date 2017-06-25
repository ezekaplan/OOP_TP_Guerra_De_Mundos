package model.planeta;

import model.batalla.Dañable;
import model.batalla.Estrategia;
import model.batalla.Poder;
import model.naves.Nave;
import java.util.ArrayList;
import java.util.List;

/**
 * Es la unidad de ataque de un planeta.
 */
public class Flota implements Dañable {

    private Poder poder;
    private List<Nave> naves;
    private Estrategia estrategia;

    public Flota() {
    poder = new Poder();
    this.naves = new ArrayList<>();
    }

    private void calcularPoderes() {
        for (Nave nave : naves) {
            nave.sumarPoder(this.poder);
        }
    }

    public void sumarNave(Nave nave) {
        naves.add(nave);
    }

    public Poder getPoder() {
        return poder;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    @Override
    public void recibirDaño(Poder poder) {
        //TODO Destruir naves segun el poder de defensa del planeta atacado
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
