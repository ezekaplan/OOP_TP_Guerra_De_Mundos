package model;

import model.planeta.Planeta;
import java.util.*;

/**
 * Created by ekapl1 on 5/10/17.
 */
public class Partida {

    private static final int PLANETAS_GRANDES = 10;
    private static final int PLANETAS_MEDIANOS = 70;
    private static final int PLANETAS_CHICOS = 20;

    private Espacio[][] mapa;
    private int cantPlanetas;
    private int cantUsuarios;



    public void main() {

    }

    public class Rules {
        //Pocentaje distributivo de planetas


    }

    private void crearMapa(int cantPlanetas) {

        mapa = new Espacio[cantPlanetas][cantPlanetas];
        int cantPlanetasGrandes = cantPlanetas * PLANETAS_GRANDES / 100;
        int cantPlaetasMedianos = cantPlanetas * PLANETAS_MEDIANOS / 100;
        int cantPlanetasChicos = cantPlanetas * PLANETAS_CHICOS / 100;


    }

    private void crearPlanetas(int cantPlanetasGrandes, int cantPlaetasMedianos, int cantPlanetasChicos) {
        Stack<Planeta> planetas = new Stack<>();
        int totalPlanetas = cantPlanetasChicos + cantPlaetasMedianos + cantPlanetasGrandes;
        while (totalPlanetas != 0) {
            totalPlanetas--;

        }

    }



    private void distribuirPlanetas() {

    }

    public class Espacio {
        private Planeta planeta;
    }

}
