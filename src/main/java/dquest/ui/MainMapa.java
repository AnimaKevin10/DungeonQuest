package dquest.ui;

import dquest.estructuras.grafo.*;
import dquest.jugador.Jugador;

import javax.swing.*;

public class MainMapa {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("DungeonQuest - Mapa");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(800, 600);

            Mapa mapa = crearMapa();
            ColaJugadores jugadores = crearJugadores(mapa);

            PanelMapa panel = new PanelMapa(mapa, jugadores);
            ventana.add(panel);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }

    private static Mapa crearMapa() {
        Mapa mapa = new Mapa();

        // Usamos el método agregarNodo(nombre, x, y) directamente en lugar de crear NodoMapa
        mapa.agregarNodo("Aldea", 100, 100);
        mapa.agregarNodo("Bosque", 300, 150);
        mapa.agregarNodo("Cueva", 500, 100);
        mapa.agregarNodo("Ruinas", 200, 300);
        mapa.agregarNodo("Calaveras", 400, 300);
        mapa.agregarNodo("Templo", 300, 450);

        mapa.conectarNodos("Aldea", "Bosque");
        mapa.conectarNodos("Bosque", "Cueva");
        mapa.conectarNodos("Bosque", "Ruinas");
        mapa.conectarNodos("Cueva", "Calaveras");
        mapa.conectarNodos("Ruinas", "Templo");
        mapa.conectarNodos("Calaveras", "Templo");

        return mapa;
    }

    private static ColaJugadores crearJugadores(Mapa mapa) {
        ColaJugadores cola = new ColaJugadores();

        Jugador j1 = new Jugador("Link", mapa.buscarNodoPorNombre("Aldea"));
        Jugador j2 = new Jugador("Zelda", mapa.buscarNodoPorNombre("Bosque"));
        Jugador j3 = new Jugador("Ganondorf", mapa.buscarNodoPorNombre("Cueva"));

        NodoColaJugador nodoJ1 = new NodoColaJugador(j1);
        NodoColaJugador nodoJ2 = new NodoColaJugador(j2);
        NodoColaJugador nodoJ3 = new NodoColaJugador(j3);

        cola.encolar(nodoJ1);
        cola.encolar(nodoJ2);
        cola.encolar(nodoJ3);

        return cola;
    }
}
