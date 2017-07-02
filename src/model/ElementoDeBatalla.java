package model;

public abstract class ElementoDeBatalla extends ElementoDeJuego {

    protected int nivel = 1;
    protected int costo;


    public ElementoDeBatalla(int costo) {
        this.costo = costo;

    }

    public int getNivel() {

        return nivel;
    }

    public void subirNivel() {
        nivel ++;
    }

    public int getCosto() {
        return costo * nivel;
    }
}
