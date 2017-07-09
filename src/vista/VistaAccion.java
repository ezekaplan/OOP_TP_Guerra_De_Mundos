package vista;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;

import model.Universo;
import sun.rmi.server.InactiveGroupException;
import vista.*;

/**
 * Created by Nicolás on 02/07/2017.
 */
public class VistaAccion extends JFrame{

    private int jugadorActivo = Universo.getInstance().getJugadorActivo();

    VistaAccion(VistaJuego ventana, int n){
        this.setTitle("Age of Guerra del Espacio");
        this.setSize(320, 300);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        switch (n){
            //Para producir naves:
            case 1:
                this.setSize(400, 300);
                JLabel textoNave = new JLabel("<html><body>Producir naves<br>Elija el tipo de nave a crear:</body></html>");
                textoNave.setBounds(10, 1, 300, 60);
                this.add(textoNave);
                String[] navesStrings = {"Nave colonizadora", "Nave de ataque", "Nave destructora"};
                JComboBox navesLista = new JComboBox(navesStrings);
                navesLista.setSelectedIndex(0);
                navesLista.setBounds(10, 70, 200, 25);
                this.add(navesLista);
                JLabel naveSeleccionadaTexto = new JLabel("");
                naveSeleccionadaTexto.setBounds(10, 100, 390, 20);
                JTextField ingresado = new JTextField();
                ingresado.setBounds(10, 130, 150, 20);
                this.add(ingresado);
                JLabel ingresarPlanetaTexto = new JLabel("Ingrese el planeta donde iran las naves.");
                ingresarPlanetaTexto.setBounds(10, 170, 300, 20);
                this.add(ingresarPlanetaTexto);
                JTextField ingresadoPlaneta = new JTextField();
                ingresadoPlaneta.setBounds(10, 200, 150, 20);
                this.add(ingresadoPlaneta);
                JButton aceptarNavesAtaque = new JButton();
                aceptarNavesAtaque.setText("Aceptar y pasar turno");
                aceptarNavesAtaque.setBounds(100, 240, 200, 20);
                this.add(aceptarNavesAtaque);

                navesLista.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        switch(navesLista.getSelectedIndex()){
                            case 0://Esta seleccionado Nave colonizadora.
                                naveSeleccionadaTexto.setText("Ingrese cantidad de naves colonizadoras a crear (2 Recursos):");
                                VistaAccion.this.add(naveSeleccionadaTexto);
                                VistaAccion.this.repaint();
                                break;
                            case 1://Esta seleccionado Nave de ataque.
                                naveSeleccionadaTexto.setText("Ingrese cantidad de naves de ataque a crear (1 Recurso):");
                                VistaAccion.this.add(naveSeleccionadaTexto);
                                VistaAccion.this.repaint();
                                break;
                            case 2://Esta seleccionado Nave destructora.
                                naveSeleccionadaTexto.setText("Ingrese cantidad de naves destructoras a crear (3 Recursos):");
                                VistaAccion.this.add(naveSeleccionadaTexto);
                                VistaAccion.this.repaint();
                                break;
                            default:
                                break;
                        }
                    }
                });
                aceptarNavesAtaque.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        switch(navesLista.getSelectedIndex()){
                            case 0://Esta seleccionado Nave colonizadora.2 Recursos
                                if(Universo.getInstance().getJugadores().get(jugadorActivo).getRecursos() >= (2 * Integer.parseInt(ingresado.getText())) ){
                                    int cantidadNavesColonizadoras = Integer.parseInt(ingresado.getText());//Cantidad de naves a crear.
                                    Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoPlaneta.getText())-1).addNaveColonizadora(cantidadNavesColonizadoras);
                                    Universo.getInstance().getJugadores().get(jugadorActivo).aumentarRecursos(-1 * (2 * Integer.parseInt(ingresado.getText())));//Le resto los recuros gastados.
                                    System.out.println("Se han agregado " + cantidadNavesColonizadoras + " naves de batalla al planeta ingresado.");
                                    pasarTurno(ventana);
                                }else{
                                    System.out.println("Recursos insuficientes!");
                                }
                                break;
                            case 1://Esta seleccionado Nave de ataque.1 Recurso
                                if(Universo.getInstance().getJugadores().get(jugadorActivo).getRecursos() >= Integer.parseInt(ingresado.getText()) ){
                                    int cantidadNavesBatalla = Integer.parseInt(ingresado.getText());//Cantidad de naves a crear.
                                    Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoPlaneta.getText())-1).addNave(cantidadNavesBatalla);
                                    Universo.getInstance().getJugadores().get(jugadorActivo).aumentarRecursos(-1 * (Integer.parseInt(ingresado.getText())));//Le resto los recuros gastados.
                                    System.out.println("Se han agregado " + cantidadNavesBatalla + " naves de batalla al planeta ingresado.");
                                    pasarTurno(ventana);
                                }else{
                                    System.out.println("Recursos insuficientes!");
                                }
                                break;
                            case 2://Esta seleccionado Nave destructora.3 Recursos
                                if(Universo.getInstance().getJugadores().get(jugadorActivo).getRecursos() >= (3 * Integer.parseInt(ingresado.getText())) ){
                                    int cantidadNavesDestructoras = Integer.parseInt(ingresado.getText());//Cantidad de naves a crear.
                                    Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoPlaneta.getText())-1).addNaveDestructora(cantidadNavesDestructoras);
                                    Universo.getInstance().getJugadores().get(jugadorActivo).aumentarRecursos(-1 * (3 * Integer.parseInt(ingresado.getText())));//Le resto los recuros gastados.
                                    System.out.println("Se han agregado " + cantidadNavesDestructoras + " naves de batalla al planeta ingresado.");
                                    pasarTurno(ventana);
                                }else{
                                    System.out.println("Recursos insuficientes!");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                });
                break;
            //Para producir torretas:
            case 2:
                this.setSize(400, 300);
                JLabel textoTorretas = new JLabel("<html><body>Crear torretas<br>Ingrese la cantidad de torretas (5recursos):</body></html>");
                textoTorretas.setBounds(10, 20, 300, 50);
                this.add(textoTorretas);
                JTextField ingresadoTorretas = new JTextField();
                JLabel planetaTorreta = new JLabel("Ingrese el planeta donde crear torreta:");
                JTextField ingresadoPlanetaT = new JTextField();
                ingresadoTorretas.setBounds(10, 80, 150, 20);
                planetaTorreta.setBounds(10, 110, 300, 30);
                ingresadoPlanetaT.setBounds(10, 150, 150, 20);
                this.add(ingresadoTorretas);
                this.add(planetaTorreta);
                this.add(ingresadoPlanetaT);
                JButton aceptarTorretas = new JButton();
                aceptarTorretas.setBounds(100, 240, 200, 20);
                aceptarTorretas.setText("Aceptar y pasar turno");
                this.add(aceptarTorretas);

                aceptarTorretas.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        if(Universo.getInstance().getJugadores().get(jugadorActivo).getRecursos() >= (5 * Integer.parseInt(ingresadoTorretas.getText())) ){
                            int cantidadTorretas = Integer.parseInt(ingresadoTorretas.getText());//Cantidad de naves a crear.
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoPlanetaT.getText())-1).addTorreta(cantidadTorretas);
                            Universo.getInstance().getJugadores().get(jugadorActivo).aumentarRecursos(-1 * (5 * Integer.parseInt(ingresadoTorretas.getText())));//Le resto los recuros gastados.
                            System.out.println("Se han agregado " + cantidadTorretas + " naves de batalla al planeta ingresado.");
                            pasarTurno(ventana);
                        }else{
                            System.out.println("Recursos insuficientes!");
                        }
                    }
                });
                break;
            //Para aumentar capacidad de produccion (cuesta 3 recursos del jugador):
            case 3:
                JLabel texto = new JLabel("¿Cuál planeta quiere mejorar?:");
                texto.setBounds(10, 20, 250, 20);
                this.add(texto);
                JTextField numero = new JTextField();
                numero.setBounds(10, 50, 150, 20);
                this.add(numero);
                JLabel informacion = new JLabel("");
                informacion.setBounds(10, 80, 300, 20);
                this.add(informacion);
                numero.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        if(numero.getText() != null){
                            int jugadorAct = Universo.getInstance().getJugadorActivo();
                            if(Integer.parseInt(numero.getText()) > 0){
                                if(Integer.parseInt(numero.getText())-1 < Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().size())
                                    informacion.setText("Planeta: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getTipoPlaneta().name() +
                                            " Cap. Prod. actual: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                                //System.out.println("Texto cambiado");
                            }
                        }else{
                            informacion.setText("Numero de planeta inválido.");
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        informacion.setText("");
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        if(numero.getText() != null){
                            int jugadorAct = Universo.getInstance().getJugadorActivo();
                            if(Integer.parseInt(numero.getText()) > 0){
                                if(Integer.parseInt(numero.getText())-1 < Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().size())
                                    informacion.setText("Planeta: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getTipoPlaneta().name() +
                                            " Cap. Prod. actual: " + Universo.getInstance().getJugadores().get(jugadorAct).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                                //System.out.println("Texto cambiado");
                            }
                        }else{
                            informacion.setText("Numero de planeta inválido.");
                        }
                    }

                });
                JButton aceptar = new JButton();
                aceptar.setText("Aceptar y pasar turno");
                aceptar.setBounds(60, 240, 200, 20);
                this.add(aceptar);

                aceptar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        if(Universo.getInstance().getJugadores().get(jugadorActivo).getRecursos() >= 3){
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(numero.getText())-1).aumentarCapacidadDeProduccion();
                            Universo.getInstance().getJugadores().get(jugadorActivo).aumentarRecursos(-3);//Le resto los recuros gastados.
                            System.out.println("Cap. prod.: "+Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(numero.getText())-1).getCapacidadDeProduccion());
                            pasarTurno(ventana);
                        }else{
                            JPanel pan = new JPanel();
                            pan.setLayout(new FlowLayout());
                            JLabel mensaje = new JLabel("Recursos insuficientes!");
                            mensaje.setBounds(10, 10, 180, 30);
                            pan.add(mensaje);
                            JDialog error = new JDialog(VistaAccion.this, "Error", true);
                            error.setSize(320, 320);
                            error.setVisible(true);
                            error.add(pan);
                            System.out.println("Recursos insuficientes.");
                        }
                    }
                });
                /*numero.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    }
                });*/
                break;
            //Para colonizar:
            case 4:
                break;
            //Para atacar naves:
            case 5:
                break;
            //Para atacar planetas:
            case 6:
                break;
            default:
                System.out.println("Formulario creado.");
        }

    }

    public void pasarTurno(VistaJuego ventana){
        int cantidadJugadores = Universo.getInstance().getJugadores().size(), aux;

        ventana.dispose();
        if(Universo.getInstance().getJugadorActivo()+1 >= cantidadJugadores){//Cambio el jugador activo.
            Universo.getInstance().setJugadorActivo(0);
        }else{
            Universo.getInstance().setJugadorActivo(Universo.getInstance().getJugadorActivo()+1);
        }
        //Actualizo recursos de jugadores:
        for(int i = 0; i < cantidadJugadores; i++){
            aux = 0;
            int cantidadPlanetasDelJugador = Universo.getInstance().getJugadores().get(i).getCantidadPlanetas();
            int capacidadDeProduccionDelPlaneta = 0;
            for(int j = 0; j < cantidadPlanetasDelJugador; j++){
                capacidadDeProduccionDelPlaneta = Universo.getInstance().getJugadores().get(i).getPlanetas().get(j).getCapacidadDeProduccion();
                aux += capacidadDeProduccionDelPlaneta;
                Universo.getInstance().getJugadores().get(i).getPlanetas().get(j).aumentarPoblacion(capacidadDeProduccionDelPlaneta);
            }
            Universo.getInstance().getJugadores().get(i).aumentarRecursos(aux);
        }
        VistaJuego nuevo = new VistaJuego();
        nuevo.setVisible(true);
        VistaAccion.this.dispose();
    }
}
