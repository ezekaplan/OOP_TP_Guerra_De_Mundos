package model.planeta;


import model.ElementoDeBatalla;

public class Torreta extends ElementoDeBatalla {

    private static final Integer fuerza = 500;
    private static final Integer costo = 6;

    public Torreta() {
        super(costo);
    }

    public int getPoder(){
        return fuerza * nivel;
    }
}
