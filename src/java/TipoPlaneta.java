package java;

/**
 * Created by ekapl1 on 5/10/17.
 */
public enum TipoPlaneta {

    CHICO(200, 10, 2),
    MEDIANO(600, 6, 6),
    GRANDE(1000, 2, 10);

    private int capacidadPoblacion;
    private int velocidadCrecimiento;
    private int capacidadProduccion;

    TipoPlaneta(int capacidadPoblacion, int velocidadCrecimiento, int capacidadProduccion) {
        this.capacidadPoblacion = capacidadPoblacion;
        this.velocidadCrecimiento = velocidadCrecimiento;
        this.capacidadProduccion = capacidadProduccion;
    }

    public int getVelocidadCrecimiento() {
        return velocidadCrecimiento;
    }

    public int getCapacidadProduccion() {
        return capacidadProduccion;
    }

    public int getCapacidadPoblacion() {
        return capacidadPoblacion;
    }
}
