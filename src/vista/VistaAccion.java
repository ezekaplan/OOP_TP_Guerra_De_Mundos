package vista;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.Jugador;
import model.Universo;
import model.planeta.Planeta;
import sun.rmi.server.InactiveGroupException;
import vista.*;

/**
 * Created by Nicolás on 02/07/2017.
 */
public class VistaAccion extends JFrame{

    private int jugadorActivo = Universo.getInstance().getJugadorActivo();
    private List<Planeta> listaPlanetasDeOtroJugador = new ArrayList<Planeta>();

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
                this.setSize(800, 300);
                JLabel tituloColonizadora = new JLabel("<html><body>Ataque colonizador<br>Seleccione el jugador:</body></html>");
                tituloColonizadora.setBounds(10, 10, 150, 50);
                JComboBox listaJugadores = new JComboBox();
                for(Jugador i : Universo.getInstance().getJugadores()){
                    if(i.getNombre() != Universo.getInstance().getJugadores().get(Universo.getInstance().getJugadorActivo()).getNombre())
                        listaJugadores.addItem(i.getNombre());
                }
                listaJugadores.setBounds(10, 60, 150, 20);
                listaJugadores.setSelectedIndex(0);
                this.add(tituloColonizadora);
                this.add(listaJugadores);
                JLabel info = new JLabel("Detalles jugador seleccionado:");
                info.setBounds(300, 10, 200, 20);
                this.add(info);
                JTextArea informacionDetallada = new JTextArea();
                informacionDetallada.setText("");
                informacionDetallada.setEditable(false);
                informacionDetallada.setBounds(300, 40, 350, 180);
                informacionDetallada.setLineWrap(true);
                informacionDetallada.setWrapStyleWord(true);
                this.add(informacionDetallada);
                listaJugadores.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Obtengo la lista de planetas del jugador seleccionado:
                        informacionDetallada.setText("");
                        Jugador seleccionado = new Jugador(null);
                        String nombreSeleccionado = listaJugadores.getSelectedItem().toString();
                        for(Jugador i : Universo.getInstance().getJugadores())
                            if(i.getNombre().equals(nombreSeleccionado))
                                seleccionado = i;
                        //listaPlanetasDeOtroJugador = Universo.getInstance().getJugadores().get(listaJugadores.getSelectedIndex()).getPlanetas();
                        listaPlanetasDeOtroJugador = seleccionado.getPlanetas();
                        int j = 1;
                        for(Planeta i : listaPlanetasDeOtroJugador){
                            informacionDetallada.append("Planeta: " + j + " Poblacion: " + i.getPoblacion() + " Colonizadoras: " + i.getNavesColonizadoras().size() + "\n");
                            j += 1;
                        }
                        VistaAccion.this.repaint();
                    }
                });
                JLabel atacar = new JLabel("Ingrese el planeta a atacar del jugador:");
                atacar.setBounds(10, 90, 250, 20);
                this.add(atacar);
                JTextField ingresadoPlaneta4 = new JTextField();
                ingresadoPlaneta4.setBounds(10, 120, 150, 20);
                this.add(ingresadoPlaneta4);
                JLabel atacarDesde = new JLabel("Ingrese el planeta desde que ataca:");
                atacarDesde.setBounds(10, 150, 250, 20);
                this.add(atacarDesde);
                JTextField ingresadoDesde4 = new JTextField();
                ingresadoDesde4.setBounds(10, 180, 150, 20);
                this.add(ingresadoDesde4);
                JButton aceptar4 = new JButton();
                aceptar4.setText("Aceptar y pasar turno");
                aceptar4.setBounds(300, 240, 200, 20);
                this.add(aceptar4);
                aceptar4.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Se desencadena la lucha.
                        //Verifico que el otro planeta tenga naves colonizadoras.
                        Jugador jugadorSeleccionado = Universo.getInstance().getJugadores().get(listaJugadores.getSelectedIndex());
                        Planeta planetaSeleccionado = Universo.getInstance().getJugadores().get(listaJugadores.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta4.getText())-1);
                        if(planetaSeleccionado.getNavesColonizadoras().size() > 0){
                            int navesEnviadas = Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde4.getText())-1).getNavesColonizadoras().size();
                            int navesDefensoras = planetaSeleccionado.getNavesColonizadoras().size();
                            int navesSobrevivientes = 0, navesARestar = 0;
                            if(navesEnviadas > navesDefensoras){
                                navesSobrevivientes = navesEnviadas - navesDefensoras;
                                navesARestar = navesDefensoras;
                            }else if(navesEnviadas == navesDefensoras){
                                navesSobrevivientes = 0;
                                navesARestar = navesEnviadas;
                            }else if(navesEnviadas < navesDefensoras){
                                navesARestar = navesEnviadas;
                                navesSobrevivientes = 0;
                            }
                            planetaSeleccionado.removerNavesColonizadoras(navesARestar);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde4.getText())-1).removerNavesColonizadoras(navesARestar);
                        }else if(planetaSeleccionado.getPoblacion() == 0){
                            //Se conquista el planeta
                            Planeta conquistado;
                            conquistado = planetaSeleccionado;
                            jugadorSeleccionado.removerPlaneta(conquistado);
                            conquistado.setPoblacion(2);
                            Universo.getInstance().getJugadores().get(jugadorActivo).agregarPlaneta(conquistado);
                        }
                        pasarTurno(ventana);
                    }
                });
                break;
            //Para atacar naves:
            case 5:
                this.setSize(800, 300);
                JLabel tituloBatalla = new JLabel("<html><body>Ataque a naves de batalla<br>Seleccione el jugador:</body></html>");
                tituloBatalla.setBounds(10, 10, 150, 50);
                JComboBox listaJugadoresBatalla = new JComboBox();
                for(Jugador i : Universo.getInstance().getJugadores()){
                    if(i.getNombre() != Universo.getInstance().getJugadores().get(Universo.getInstance().getJugadorActivo()).getNombre())
                        listaJugadoresBatalla.addItem(i.getNombre());
                }
                listaJugadoresBatalla.setBounds(10, 60, 150, 20);
                listaJugadoresBatalla.setSelectedIndex(0);
                this.add(tituloBatalla);
                this.add(listaJugadoresBatalla);
                JLabel infoBatalla = new JLabel("Detalles jugador seleccionado:");
                infoBatalla.setBounds(300, 10, 200, 20);
                this.add(infoBatalla);
                JTextArea iDetalladaBatalla = new JTextArea();
                iDetalladaBatalla.setText("");
                iDetalladaBatalla.setEditable(false);
                iDetalladaBatalla.setBounds(300, 40, 350, 180);
                iDetalladaBatalla.setLineWrap(true);
                iDetalladaBatalla.setWrapStyleWord(true);
                this.add(iDetalladaBatalla);
                listaJugadoresBatalla.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Obtengo la lista de planetas del jugador seleccionado:
                        iDetalladaBatalla.setText("");
                        Jugador seleccionado = new Jugador(null);
                        String nombreSeleccionado = listaJugadoresBatalla.getSelectedItem().toString();
                        for(Jugador i : Universo.getInstance().getJugadores())
                            if(i.getNombre().equals(nombreSeleccionado))
                                seleccionado = i;
                        //listaPlanetasDeOtroJugador = Universo.getInstance().getJugadores().get(listaJugadores.getSelectedIndex()).getPlanetas();
                        listaPlanetasDeOtroJugador = seleccionado.getPlanetas();
                        int j = 1;
                        for(Planeta i : listaPlanetasDeOtroJugador){
                            iDetalladaBatalla.append("Planeta: " + j + " Poblacion: " + i.getPoblacion() + " Naves de batalla: " + i.getNaves().size() + "\n");
                            j += 1;
                        }
                        VistaAccion.this.repaint();
                    }
                });
                JLabel atacarBatalla = new JLabel("Ingrese el planeta a atacar del jugador:");
                atacarBatalla.setBounds(10, 90, 250, 20);
                this.add(atacarBatalla);
                JTextField ingresadoPlaneta5 = new JTextField();
                ingresadoPlaneta5.setBounds(10, 120, 150, 20);
                this.add(ingresadoPlaneta5);
                JLabel atacarDesde5 = new JLabel("Ingrese el planeta desde que ataca:");
                atacarDesde5.setBounds(10, 150, 250, 20);
                this.add(atacarDesde5);
                JTextField ingresadoDesde5 = new JTextField();
                ingresadoDesde5.setBounds(10, 180, 150, 20);
                this.add(ingresadoDesde5);
                JButton aceptar5 = new JButton();
                aceptar5.setText("Aceptar y pasar turno");
                aceptar5.setBounds(300, 240, 200, 20);
                this.add(aceptar5);
                aceptar5.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Se desencadena la lucha.
                        //Verifico que el otro planeta tenga naves de batalla.
                        Jugador jugadorSeleccionado = Universo.getInstance().getJugadores().get(listaJugadoresBatalla.getSelectedIndex());
                        Planeta planetaSeleccionado = Universo.getInstance().getJugadores().get(listaJugadoresBatalla.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta5.getText())-1);
                        int navesEnviadas = Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde5.getText())-1).getNaves().size();
                        int navesDefensoras = planetaSeleccionado.getNaves().size();
                        int navesSobrevivientes = 0, navesARestar = 0;
                        if(planetaSeleccionado.getNaves().size() > 0){
                            if(navesEnviadas > navesDefensoras){
                                navesSobrevivientes = navesEnviadas - navesDefensoras;
                                navesARestar = navesDefensoras;
                            }else if(navesEnviadas == navesDefensoras){
                                navesSobrevivientes = 0;
                                navesARestar = navesEnviadas;
                            }else if(navesEnviadas < navesDefensoras){
                                navesARestar = navesEnviadas;
                                navesSobrevivientes = 0;
                            }
                            planetaSeleccionado.removerNavesBatalla(navesARestar);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde5.getText())-1).removerNavesBatalla(navesARestar);
                        }else if(planetaSeleccionado.getPoblacion() == 0){
                            //Se le resta al atacado un punto de poblacion por nave enviada.
                            Universo.getInstance().getJugadores().get(listaJugadoresBatalla.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta5.getText())-1).restarPoblacion(navesARestar);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde5.getText())-1).removerNavesBatalla(navesARestar);
                        }
                        pasarTurno(ventana);
                    }
                });
                break;
            //Para atacar planetas:
            case 6:
                this.setSize(800, 300);
                JLabel tituloDestructor = new JLabel("<html><body>Ataque a planetas<br>Seleccione el jugador:</body></html>");
                tituloDestructor.setBounds(10, 10, 150, 50);
                JComboBox listaJugadoresDestructor = new JComboBox();
                for(Jugador i : Universo.getInstance().getJugadores()){
                    if(i.getNombre() != Universo.getInstance().getJugadores().get(Universo.getInstance().getJugadorActivo()).getNombre())
                        listaJugadoresDestructor.addItem(i.getNombre());
                }
                listaJugadoresDestructor.setBounds(10, 60, 150, 20);
                listaJugadoresDestructor.setSelectedIndex(0);
                this.add(tituloDestructor);
                this.add(listaJugadoresDestructor);
                JLabel infoDestructor = new JLabel("Detalles jugador seleccionado:");
                infoDestructor.setBounds(300, 10, 200, 20);
                this.add(infoDestructor);
                JTextArea iDetalladaDestructor = new JTextArea();
                iDetalladaDestructor.setText("");
                iDetalladaDestructor.setEditable(false);
                iDetalladaDestructor.setBounds(300, 40, 350, 180);
                iDetalladaDestructor.setLineWrap(true);
                iDetalladaDestructor.setWrapStyleWord(true);
                this.add(iDetalladaDestructor);
                listaJugadoresDestructor.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Obtengo la lista de planetas del jugador seleccionado:
                        iDetalladaDestructor.setText("");
                        Jugador seleccionado = new Jugador(null);
                        String nombreSeleccionado = listaJugadoresDestructor.getSelectedItem().toString();
                        for(Jugador i : Universo.getInstance().getJugadores())
                            if(i.getNombre().equals(nombreSeleccionado))
                                seleccionado = i;
                        //listaPlanetasDeOtroJugador = Universo.getInstance().getJugadores().get(listaJugadores.getSelectedIndex()).getPlanetas();
                        listaPlanetasDeOtroJugador = seleccionado.getPlanetas();
                        int j = 1;
                        for(Planeta i : listaPlanetasDeOtroJugador){
                            iDetalladaDestructor.append("Planeta: " + j + " Poblacion: " + i.getPoblacion() + " Naves de batalla: " + i.getNaves().size() + "\n");
                            j += 1;
                        }
                        VistaAccion.this.repaint();
                    }
                });
                JLabel atacarDestructor = new JLabel("Ingrese el planeta a atacar del jugador:");
                atacarDestructor.setBounds(10, 90, 250, 20);
                this.add(atacarDestructor);
                JTextField ingresadoPlaneta6 = new JTextField();
                ingresadoPlaneta6.setBounds(10, 120, 150, 20);
                this.add(ingresadoPlaneta6);
                JLabel atacarDesde6 = new JLabel("Ingrese el planeta desde que ataca:");
                atacarDesde6.setBounds(10, 150, 250, 20);
                this.add(atacarDesde6);
                JTextField ingresadoDesde6 = new JTextField();
                ingresadoDesde6.setBounds(10, 180, 150, 20);
                this.add(ingresadoDesde6);
                JButton aceptar6 = new JButton();
                aceptar6.setText("Aceptar y pasar turno");
                aceptar6.setBounds(300, 240, 200, 20);
                this.add(aceptar6);
                aceptar6.addActionListener(new java.awt.event.ActionListener() {//Listener del comboBox.
                    public void actionPerformed(ActionEvent evt) {
                        //Se desencadena la lucha.
                        //Verifico que el otro planeta tenga naves de batalla.
                        Jugador jugadorSeleccionado = Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex());
                        Planeta planetaSeleccionado = Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1);
                        int navesEnviadas = Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).getFlotas().size();
                        int torretasDefensoras = planetaSeleccionado.getTorretas().size();
                        int navesSobrevivientes = 0, navesARestar = 0;

                        if(navesEnviadas > 0 && (navesEnviadas / 2) > torretasDefensoras && torretasDefensoras > 0){
                            navesARestar = navesEnviadas / 2;
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).restarTorretas(navesARestar);
                            navesARestar = torretasDefensoras * 2;
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(navesARestar);
                            navesEnviadas = navesEnviadas - (torretasDefensoras * 2);
                        }else if((navesEnviadas / 2) == torretasDefensoras){
                            navesARestar = navesEnviadas / 2;
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).restarTorretas(navesARestar);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerDestructoras(navesARestar);
                            navesEnviadas = 0;
                        }else if((navesEnviadas / 2) < torretasDefensoras){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).restarTorretas(torretasDefensoras);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras((torretasDefensoras*2));
                            navesEnviadas = 0;
                        }

                        int destructorasDefensoras = planetaSeleccionado.getFlotas().size();
                        if(navesEnviadas > 0 && navesEnviadas > destructorasDefensoras && destructorasDefensoras > 0){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerDestructoras(destructorasDefensoras);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(destructorasDefensoras);
                            navesEnviadas = navesEnviadas - destructorasDefensoras;
                        }else if(navesEnviadas == destructorasDefensoras){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerDestructoras(destructorasDefensoras);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(destructorasDefensoras);
                            navesEnviadas = 0;
                        }else if(navesEnviadas < destructorasDefensoras){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerDestructoras(navesEnviadas);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(navesEnviadas);
                            navesEnviadas = 0;
                        }

                        int colonizadorasDefensoras = planetaSeleccionado.getNavesColonizadoras().size();
                        if(navesEnviadas > 0 && navesEnviadas > colonizadorasDefensoras && colonizadorasDefensoras > 0){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerNavesColonizadoras(colonizadorasDefensoras);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(colonizadorasDefensoras/2);
                            navesEnviadas = navesEnviadas - (colonizadorasDefensoras/2);
                        }else if(navesEnviadas == colonizadorasDefensoras){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerNavesColonizadoras(colonizadorasDefensoras);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(colonizadorasDefensoras/2);
                            navesEnviadas = navesEnviadas / 2;
                        }else if(navesEnviadas < colonizadorasDefensoras){
                            navesARestar = colonizadorasDefensoras - (navesEnviadas * 2);
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).removerNavesColonizadoras(navesARestar);
                            navesARestar = navesEnviadas - (colonizadorasDefensoras / 2);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(navesARestar);
                            navesEnviadas = navesEnviadas - (colonizadorasDefensoras / 2);
                        }

                        int pobladoresDefensor = planetaSeleccionado.getPoblacion();
                        if(navesEnviadas > 0 && navesEnviadas > pobladoresDefensor && pobladoresDefensor > 0){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setPoblacion(0);
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setCapacidadDeProduccion(0);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(pobladoresDefensor/5);
                            navesEnviadas = navesEnviadas - (pobladoresDefensor/5);
                        }else if(navesEnviadas == pobladoresDefensor){
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setPoblacion(0);
                            Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setCapacidadDeProduccion(0);
                            Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(pobladoresDefensor/5);
                            navesEnviadas = navesEnviadas - (pobladoresDefensor/5);
                        }else if(navesEnviadas < pobladoresDefensor){
                            if(pobladoresDefensor - (navesEnviadas * 5) > 0)
                                Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).reducirPoblacion(navesEnviadas*5);
                            else if(pobladoresDefensor - (navesEnviadas*5) <= 0) {
                                Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setPoblacion(0);
                                Universo.getInstance().getJugadores().get(listaJugadoresDestructor.getSelectedIndex()).getPlanetas().get(Integer.parseInt(ingresadoPlaneta6.getText())-1).setCapacidadDeProduccion(0);
                            }
                            if(navesEnviadas - (pobladoresDefensor/5) <= 0)
                                Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(navesEnviadas);
                            else
                                Universo.getInstance().getJugadores().get(jugadorActivo).getPlanetas().get(Integer.parseInt(ingresadoDesde6.getText())-1).removerDestructoras(pobladoresDefensor/5);
                        }

                        pasarTurno(ventana);
                    }
                });
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
