package java.model;

public enum TipoPlaneta {

    CHICO(200, 10, 2),
    MEDIANO(600, 6, 6),
    GRANDE(1000, 2, 10);

    private int capacidadPoblacion;
    private int velocidadCrecimientoPob;
    private int capacidadProduccion;

    TipoPlaneta(int capacidadPoblacion, int velocidadCrecimientoPob, int capacidadProduccion) {
        this.capacidadPoblacion = capacidadPoblacion;
        this.velocidadCrecimientoPob = velocidadCrecimientoPob;
        this.capacidadProduccion = capacidadProduccion;
    }

    public int getVelocidadCrecimientoPob() {
        return velocidadCrecimientoPob;
    }

    public int getCapacidadProduccion() {
        return capacidadProduccion;
    }

    public int getCapacidadPoblacion() {
        return capacidadPoblacion;
    }
}
