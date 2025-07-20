package dquest.juego;

import dquest.estructuras.lineales.ColaJugadores;
import dquest.jugador.Jugador;

public class PruebaCola {
    public static void main(String[] args) {
        ColaJugadores cola = new ColaJugadores();
        cola.encolar(new Jugador("Kevin"));
        cola.encolar(new Jugador("Rosario"));
        cola.encolar(new Jugador("Víctor"));

        for (int i = 0; i < 6; i++) {
            System.out.println("Turno de: " + cola.obtenerJugadorActual().getNombre());
            cola.avanzarTurno();
        }
    }
}
