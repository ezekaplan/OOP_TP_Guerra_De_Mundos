package java.entities;

/**
 * Created by ekapl1 on 5/10/17.
 */
public enum TipoPlaneta {

    CHICO(10, 2),
    MEDIANO(6, 6),
    GRANDE(2, 10);


    private int velocidadCrecimiento;
    private int capacidadProduccion;

    TipoPlaneta(int velocidadCrecimiento, int capacidadProduccion) {
        this.velocidadCrecimiento = velocidadCrecimiento;
        this.capacidadProduccion = capacidadProduccion;
    }



    public int getVelocidadCrecimiento() {
        return velocidadCrecimiento;
    }

    public int getCapacidadProduccion() {
        return capacidadProduccion;
    }
}
