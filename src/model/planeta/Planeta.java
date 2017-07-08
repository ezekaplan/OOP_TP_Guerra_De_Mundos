package model.planeta;

import model.ConstruccionElementoBatalla;
import model.ElementoDeBatalla;
import model.ElementoDeJuego;
import model.Jugador;
import model.batalla.Dañable;
import model.batalla.Poder;
import model.naves.Nave;
import model.naves.NaveBatalla;
import observer.IObservador;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Planeta extends ElementoDeJuego implements Dañable, IObservador<ElementoDeBatalla> {

    private UUID uuid = UUID.randomUUID();

    private int poblacion = 2;
    private int capacidadDeProduccion = 1;
    private Jugador propietario;
    private TipoPlaneta tipoPlaneta;
    private List<Nave> naves = new ArrayList<>();
    private List<Flota> flotas = new ArrayList<>();
    private List<Torreta> torretas = new ArrayList<>();
    private List<ConstruccionElementoBatalla> elementoConstruccion = new ArrayList<>();

    public Planeta(Jugador propietario, TipoPlaneta tipoPlaneta) {
        this.propietario = propietario;
        this.tipoPlaneta = tipoPlaneta;
    }

    public int getCapacidadDeProduccion() {
        return capacidadDeProduccion;
    }

    @Override
    public void recibirDaño(Poder poder) {
        //TODO Destruir torretas, poblacion y naves de batalla acorde al poder de ataque de la flota
    }

    @Override
    public Poder getPoder() {
        return new Poder(poblacion, getDefensaDestructora(), getDefensaBatalla());
    }

    public TipoPlaneta getTipoPlaneta() {
        return tipoPlaneta;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void addNave(Nave nave) {
        naves.add(nave);
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public List<Torreta> getTorretas() {
        return torretas;
    }

    public void addTorreta(Torreta torreta) {
        torretas.add(torreta);
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    @Override
    public void avanzarTurno() {
        if (poblacion - tipoPlaneta.getVelocidadCrecimientoPob() != tipoPlaneta.getCapacidadPoblacion()) {
            this.poblacion += tipoPlaneta.getVelocidadCrecimientoPob();
        }
    }

    private int getDefensaBatalla() {
        int defensaBatalla = 0;
        for (Nave nave : naves) {
            if (nave instanceof NaveBatalla) {
                defensaBatalla += nave.getPoder();
            }
        }
        return defensaBatalla;
    }

    private int getDefensaDestructora() {
        int defensaDestructora = 0;
        for (Torreta torreta : torretas) {
            defensaDestructora += torreta.getPoder();
        }
        return defensaDestructora;
    }

    @Override
    public void actualizar(ElementoDeBatalla elemento) {
        elementoConstruccion.remove(elemento);
        if(elemento instanceof Torreta) {
            torretas.add((Torreta) elemento);
        }else if (elemento instanceof Nave) {
            naves.add((Nave) elemento);
        }
    }

    public List<ConstruccionElementoBatalla> getElementoConstruccion() {
        return elementoConstruccion;
    }

    public void addElementoConstruccion(ConstruccionElementoBatalla construccionElementoBatalla) {
        elementoConstruccion.add(construccionElementoBatalla);
    }

    public void aumentarCapacidadDeProduccion(){
        this.capacidadDeProduccion += 1;
    }

    public void aumentarPoblacion(){
        this.poblacion += capacidadDeProduccion;
    }
}
