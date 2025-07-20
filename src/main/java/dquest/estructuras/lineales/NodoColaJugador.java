package dquest.estructuras.lineales;
import dquest.jugador.Jugador;

public class NodoColaJugador {
    private Jugador jugador;
    private NodoColaJugador siguiente;

    public NodoColaJugador(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public NodoColaJugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaJugador siguiente) {
        this.siguiente = siguiente;
    }
}
