package model.planeta;

public enum TipoPlaneta {

    CHICO(200, 10, 5),
    MEDIANO(600, 6, 10),
    GRANDE(1000, 2, 15);

    public int capacidadPoblacion;
    public int velocidadCrecimientoPob;
    public int capacidadProduccion;

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
