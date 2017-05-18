package java;

import java.util.ArrayList;
import java.util.List;

public class Planeta {

    private Integer capPoblacion;
    private TipoPlaneta tipoPlaneta;
    private List<Nave> naves = new ArrayList<>();
    private List<Torreta> torretas = new ArrayList<>();

    public Planeta(TipoPlaneta tipoPlaneta) {
        this.tipoPlaneta = tipoPlaneta;
    }

    public Planeta(TipoPlaneta tipoPlaneta, List<Nave> naves) {
        this.tipoPlaneta = tipoPlaneta;
        this.naves = naves;
    }

    public Planeta(TipoPlaneta tipoPlaneta, List<Torreta> torretas) {
        this.tipoPlaneta = tipoPlaneta;
        this.torretas = torretas;
    }

    public Planeta(TipoPlaneta tipoPlaneta, List<Nave> naves, List<Torreta> torretas) {
        this.tipoPlaneta = tipoPlaneta;
        this.naves = naves;
        this.torretas = torretas;
    }

    public TipoPlaneta getTipoPlaneta() {
        return tipoPlaneta;
    }

    public void setTipoPlaneta(TipoPlaneta tipoPlaneta) {
        this.tipoPlaneta = tipoPlaneta;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }
}
