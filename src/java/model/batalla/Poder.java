package java.model.batalla;

public class Poder {

    private int poderColonizador, poderDestructor, poderBatalla;

    public Poder() {}

    public Poder(int poderColonizador, int poderDestructor, int poderBatalla) {
        this.poderColonizador = poderColonizador;
        this.poderDestructor = poderDestructor;
        this.poderBatalla = poderBatalla;
    }

    public int getPoderColonizador() {
        return poderColonizador;
    }

    public void setPoderColonizador(int poderColonizador) {
        this.poderColonizador = poderColonizador;
    }

    public int getPoderDestructor() {
        return poderDestructor;
    }

    public void setPoderDestructor(int poderDestructor) {
        this.poderDestructor = poderDestructor;
    }

    public int getPoderBatalla() {
        return poderBatalla;
    }

    public void setPoderBatalla(int poderBatalla) {
        this.poderBatalla = poderBatalla;
    }
}
