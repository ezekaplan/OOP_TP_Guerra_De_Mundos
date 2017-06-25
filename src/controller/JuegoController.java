package controller;

import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import model.planeta.TipoPlaneta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoController {

    private Universo modelo;
    List<Jugador> jugadores = new ArrayList<>();
    List<Planeta> planetas = new ArrayList<>();


    public void crearUniverso(List<JTextField> jugadoresList, int p, Universo m){
        /*Le paso la lista de jugadores y la cantidad de planetas, después el resto lo hace este método.
        * Crea la lista de planetas, la de jugadores, y las setea en el modelo.*/
        this.modelo = m;
        int planetasPorJugador = p / jugadoresList.size(), aux = 0, indiceLista = 0;//Imaginemos que la cant de planetas es múltiplo de los jugadores.

        //Paso los jugadores a la lista de jugadores:
        String nombre = null;
        for(int i = 0; i < jugadoresList.size(); i++){
            nombre = jugadoresList.get(i).getText();
            Jugador nuevo = new Jugador(nombre);
            jugadores.add(nuevo);
        }
        //Termine de crear la lista de los jugadores, ahora me falta la lista de planetas.

        //La asignacion de los planetas es random.
        //Creo los tipoPlaneta:
        Random aleatorio = new Random();
        do{
            for(aux = planetasPorJugador; aux > 0; aux--) {
                aux = aleatorio.nextInt(3001);//Genera un random entre 0 y 3000.
                if (aux < 1001) {//Si esta entre 0 y 1000 es un planeta chico.
                    TipoPlaneta chico = TipoPlaneta.CHICO;//Cree la enum.
                    //Creo el tipoDePlaneta:
                    Planeta planetaChico = new Planeta(jugadores.get(indiceLista), chico);
                } else if (aux > 1000 && aux < 2001) {//Aux esta entre 1000 y 2000. Planeta mediano.
                    TipoPlaneta mediano = TipoPlaneta.MEDIANO;//Cree la enum.
                    //Creo el tipoDePlaneta:
                    Planeta planetaChico = new Planeta(jugadores.get(indiceLista), mediano);
                } else {//Aux es mayor que 2000. Planeta grande.
                    TipoPlaneta grande = TipoPlaneta.GRANDE;//Cree la enum.
                    //Creo el tipoDePlaneta:
                    Planeta planetaChico = new Planeta(jugadores.get(indiceLista), grande);
                }
            }
            indiceLista++;
            p--;
        }while(p > 0);
        //Ya tengo las dos listas completas ahora creo el universo:
        modelo.setJugadores(jugadores);
        modelo.setPlanetas(planetas);
        aux= 0;
    }
}
