package model.batalla;

import model.planeta.Flota;
import model.planeta.Planeta;
import controller.TurnoController;
import observer.Observado;

public class Batalla extends Observado<Planeta>{

    private Flota flota;
    private Planeta planeta;

    public Batalla(Flota flota, Planeta planeta) {
        this.flota = flota;
        this.planeta = planeta;
        this.registrarObservador(TurnoController.getJugador());
        this.registrarObservador(planeta.getPropietario());
    }

    public void resolverBatalla(){
        planeta.recibirDaño(flota.getPoder());
        flota.recibirDaño(planeta.getPoder());

        Poder poderDefensa = planeta.getPoder();

        if (poderDefensa.getPoderDestructor() >= 0
                && poderDefensa.getPoderBatalla() >= 0
                && poderDefensa.getPoderColonizador() >= 0) {
            planeta.setPropietario(TurnoController.getJugador());
            actualizarObservadores(planeta);
        }
    }
}
