package java.model;

import java.model.naves.Nave;
import java.model.naves.NaveBatalla;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Planeta implements Dañable {

    private UUID uuid = UUID.randomUUID();
    private Jugador propietario;
    private int poblacion;
    private TipoPlaneta tipoPlaneta;
    private List<Nave> naves = new ArrayList<>();
    private List<Torreta> torretas = new ArrayList<>();
    private List<Flota> flotas = new ArrayList<>();

    public Planeta(Jugador propietario, TipoPlaneta tipoPlaneta) {
        this.propietario = propietario;
        this.tipoPlaneta = tipoPlaneta;
    }

    public Poder getPoderDefensa(){
        return new Poder(poblacion, getDefensaDestructora(), getDefensaBatalla());
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

    @Override
    public void recibirDaño(Poder poder) {
        //TODO Destruir torretas, poblacion y naves de batalla acorde al poder de ataque de la flota
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador nuevoPropietario) {
        this.propietario.update(this);
        nuevoPropietario.update(this);
        this.propietario = nuevoPropietario;
    }
}
