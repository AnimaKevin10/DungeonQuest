package dquest.juego;

import dquest.jugador.Jugador;
import dquest.estructuras.lineales.ColaJugadores;

public class Main {
    public static void main(String[] args) {
        // Crear jugadores de prueba
        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Rosario");
        Jugador jugador3 = new Jugador("Victor");

        // Crear cola de jugadores
        ColaJugadores cola = new ColaJugadores();
        cola.encolar(jugador1);
        cola.encolar(jugador2);
        cola.encolar(jugador3);

        // Iniciar el juego
        new Juego();
    }
}
