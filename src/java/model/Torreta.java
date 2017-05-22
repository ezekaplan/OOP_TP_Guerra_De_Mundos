package java.model;


public class Torreta extends ElementoDeBatalla{

    private static final Integer fuerza = 500;

    public int getPoder(){
        return fuerza * nivel;
    }
}
