package dquest.juego;
import dquest.estructuras.lineales.ColaJugadores;
import dquest.jugador.Jugador;

public class TurnoManager {
    // Nuestra cola personalizada que mantiene un círculo de jugadores
    private ColaJugadores cola;
    public TurnoManager() {
        cola = new ColaJugadores();
    }
    public void iniciarTurnos(Jugador[] jugadores) {
        for (Jugador j : jugadores) {
            cola.encolar(j);
        }
    }
    public Jugador obtenerJugadorActual() {
        return cola.obtenerJugadorActual();
    }
    public void avanzarTurno() {
        cola.avanzarTurno();
    }
    public boolean turnosDisponibles() {
        return !cola.estaVacia();
    }
}