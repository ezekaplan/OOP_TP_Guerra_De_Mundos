package java.model;

public class Batalla {

    private Flota flota;
    private Planeta planeta;

    public Batalla(Flota flota, Planeta planeta) {
        this.flota = flota;
        this.planeta = planeta;
    }

    public void resolverBatalla(){
        planeta.recibirDaño(flota.getPoder());
        flota.recibirDaño(planeta.getPoderDefensa());

        Poder poderDefensa = planeta.getPoderDefensa();

        if (poderDefensa.getPoderDestructor() > 0
                && poderDefensa.getPoderBatalla() > 0
                && poderDefensa.getPoderColonizador() > 0) {
            planeta.setPropietario(Turno.getJugador());
        }

    }
}
