package java.model;

import java.model.naves.NaveBatalla;
import java.model.naves.NaveColonizadora;
import java.model.naves.NaveDestructora;
import java.model.planeta.Planeta;
import java.model.planeta.Torreta;
import java.observer.Observado;

public class ConstruccionElementoBatalla extends Observado<ElementoDeBatalla> {

    protected int turnosConstruccion;
    protected int turnoActual = 0;
    private ElementoDeBatalla elementoDeBatalla;
    private TipoDeElemento tipoDeElemento;

    public ConstruccionElementoBatalla(TipoDeElemento tipoDeElemento, Planeta planeta) throws IllegalAccessException, InstantiationException {
        this.tipoDeElemento = tipoDeElemento;
        elementoDeBatalla = (ElementoDeBatalla) tipoDeElemento.getReferencedClass().newInstance();
        turnosConstruccion = getTurnosConstruccion();
        this.registrarObservador(planeta);
    }

    public void avanzarTurno() {
        turnoActual++;
        if (getTurnosRestantes() == 0) {
            actualizarObservadores(elementoDeBatalla);
        }
    }

    private int getTurnosConstruccion() {
        return elementoDeBatalla.getCosto() / 2;
    }

    public int getTurnosRestantes() {
        return turnosConstruccion - turnoActual;
    }

    public enum TipoDeElemento {
        TORRETA(Torreta.class),
        NAVE_COLONIZADORA(NaveColonizadora.class),
        NAVE_BATALLA(NaveBatalla.class),
        NAVE_DESTRUCTORA(NaveDestructora.class);

        private Class referencedClass;

        TipoDeElemento(Class referencedClass) {
            this.referencedClass = referencedClass;
        }

        public Class getReferencedClass() {
            return referencedClass;
        }
    }
}
