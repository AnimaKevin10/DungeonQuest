package dquest;

import dquest.jugador.Jugador;
import dquest.jugador.Tesoro;
import dquest.ui.VentanaInventario;
import dquest.ui.VentanaRobo;

import javax.swing.*;

public class PruebaPersona3 {
    public static void main(String[] args) {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Aventurero");
        Jugador jugador2 = new Jugador("Bandido");

        // Crear algunos tesoros
        Tesoro t1 = new Tesoro("Espada Antigua", 100);
        Tesoro t2 = new Tesoro("Collar de Rubíes", 200);
        Tesoro t3 = new Tesoro("Pergamino Mágico", 150);

        Tesoro t4 = new Tesoro("Corona Dorada", 300);
        Tesoro t5 = new Tesoro("Mapa del Tesoro", 120);

        // Insertar tesoros en los inventarios
        jugador1.getInventario().insertar(t1);
        jugador1.getInventario().insertar(t2);
        jugador1.getInventario().insertar(t3);

        jugador2.getInventario().insertar(t4);
        jugador2.getInventario().insertar(t5);

        // Mostrar inventario del jugador 1
        SwingUtilities.invokeLater(() -> new VentanaInventario(jugador1));

        // Mostrar inventario del jugador 2
        SwingUtilities.invokeLater(() -> new VentanaInventario(jugador2));

        // Ventana para que jugador2 intente robar a jugador1
        SwingUtilities.invokeLater(() -> new VentanaRobo(jugador2, jugador1));
    }
}
