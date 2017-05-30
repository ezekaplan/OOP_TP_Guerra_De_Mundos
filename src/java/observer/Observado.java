package java.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado<A> {
    private List<IObservador> observadores
            = new ArrayList<IObservador>();

    public void registrarObservador(IObservador obs) {
        this.observadores.add(obs);
    }

    public void quitarObservador(IObservador obs) {
        this.observadores.remove(obs);
    }

    public void actualizarObservadores(A arg) {
        for (IObservador obs : observadores) {
            obs.actualizar(arg);
        }
    }
}
